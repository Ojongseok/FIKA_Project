package com.fika.fika_project.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.fika.fika_project.ApplicationClass.Companion.TAG
import com.fika.fika_project.ApplicationClass.Companion.retrofit
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityLoginBinding
import com.fika.fika_project.retrofit.GoogleEmail
import com.fika.fika_project.retrofit.testerCode
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.utils.spfManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.kakao.util.helper.Utility

class LoginActivity : AppCompatActivity(), LoginView {
    lateinit var binding: ActivityLoginBinding
    lateinit var mGoogleSignInClient : GoogleSignInClient
//    lateinit var resultRuncher : ActivityResultLauncher<Intent>
    private lateinit var GoogleSignResultLauncher:ActivityResultLauncher<Intent>

    public var RC_SIGN_IN = 1

    val service = LoginService(this)

    override fun onStart() {
        super.onStart()

        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account == null) {
            Log.e("Google account", "로그인 안되어있음")
        } else {
            Log.e("Google account", "로그인 완료된 상태")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

//        setResultSignUp()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

//        var keyHash = Utility.getKeyHash(this)
//        Log.e(TAG, "해시 키 값 : ${keyHash}")

        initClickListener()
        setContentView(binding.root)

        spfManager.ClearSpf()

//         편의상 시작
//        val intent = Intent(this, MainActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)

        GoogleSignResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        }

    }

//    private fun setResultSignUp(){
//        resultRuncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
//            if(result.resultCode == Activity.RESULT_OK){
//                val task : Task<GoogleSignInAccount> =
//                    GoogleSignIn.getSignedInAccountFromIntent(result.data)
//
//                handleSignInResult(task)
//                Log.d("done",resultRuncher.toString())
//
//            }
//        }
//    }

//
//    private fun googleLogin(){
//        val signIntent: Intent = mGoogleSignInClient.signInIntent
//
//        //인증허가 화면 보여주기
//        startActivityForResult(signIntent, RC_SIGN_IN)
////       resultRuncher.launch(signIntent)
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try{
            val account = completedTask.getResult(ApiException::class.java)
            val googleEmail = account?.email.toString()

            val getGoogleEmail = GoogleEmail(googleEmail)

            Log.d("유저 google 이메일",googleEmail)

            service.tryGoogleLogin(getGoogleEmail)

        }catch(e: ApiException){
            Log.w("failed","signInResult:failed code = " + e.statusCode)
        }
    }


    private fun initClickListener() {
        binding.loginQuestionTv.setOnClickListener {
            val bottomDialog = LoginDialog()
            bottomDialog.show(supportFragmentManager, bottomDialog.tag)
        }

        binding.loginTesterBtn.setOnClickListener {
                    supportFragmentManager.beginTransaction()
                .replace(R.id.login_frm, TesterloginFragment())
                .commitAllowingStateLoss()

        }

        binding.loginGoogleIv.setOnClickListener {
//            googleLogin()
            var signIntent : Intent = mGoogleSignInClient.signInIntent
            GoogleSignResultLauncher.launch(signIntent)
        }



        binding.loginKakaoIv.setOnClickListener {
            // 카카오계정으로 로그인 공통 callback 구성
            // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e(TAG, "카카오계정으로 로그인 실패", error)
                } else if (token != null) {
                    Log.i(TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
                    spfManager.saveKakaoJwt(token.accessToken).toString()
                    val kakaoToken = spfManager.getKakaoJwt()

                    Log.i(TAG, "카카오 로그인 토큰 : ${kakaoToken}")
                    service.tryKakaoLogin(kakaoToken)
                }
            }

            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                    if (error != null) {
                        Log.e(TAG, "카카오톡으로 로그인 실패", error)
                        // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                        // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                        if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                            return@loginWithKakaoTalk
                        }

                        // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                    } else if (token != null) {
                        Log.i(TAG, "카카오톡으로 로그인 성공2 : ${token.accessToken}")

                        spfManager.saveKakaoJwt(token.accessToken).toString()
                        val kakaoToken = spfManager.getKakaoJwt()

                        Log.i(TAG, "카카오 로그인 토큰 : ${kakaoToken}")
                        service.tryKakaoLogin(kakaoToken)
                    }
                }
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                val kakaoToken = spfManager.getKakaoJwt()

                Log.i(TAG, "카카오 로그인 토큰4 : ${kakaoToken}")
                service.tryKakaoLogin(kakaoToken)
            }
        }
    }

    fun changeFragment(index: Int) {
        when (index) {
            1 -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

            2 -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.login_frm, Agree01Fragment())
                    .addToBackStack(null)
                    .commit()
            }

            3 -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.login_frm, Agree02Fragment())
                    .addToBackStack(null)
                    .commit()
            }
            4 -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.login_frm, Agree03Fragment())
                    .addToBackStack(null)
                    .commit()
            }
            5 -> {
                supportFragmentManager.beginTransaction()
                    .add(R.id.login_frm, NicknameFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


    override fun onLoading() {
        binding.loginLoadingPb.visibility = View.VISIBLE
    }

    override fun onKakaoSuccess(response: BasicResponse) {
        binding.loginLoadingPb.visibility = View.GONE

        Toast.makeText(this, "KAKAO LOGIN", Toast.LENGTH_SHORT).show()
        when (response.code) {
            //성공
            1000 -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            //최초
            1002 -> { changeFragment(2) }
            4000 -> { Log.d("KAKAOLOGIN", "Access-Token이 존재하지 않는 경우") }
            4001 -> { Log.d("KAKAOLOGIN", "유효하지 않은 AccessToken") }
            else -> { Log.d("KAKAOLOGIN", "로그인 실패 : 서버 오류") }
        }
    }

    override fun onTesterSuccess(response: BasicResponse) {
        //편의상 시작 원래는 없는 함수
//        val intent = Intent(this, MainActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//        startActivity(intent)
            }

    override fun onGoogleSuccess(response: BasicResponse) {
        binding.loginLoadingPb.visibility = View.GONE

        Toast.makeText(this, "GOOGLE LOGIN", Toast.LENGTH_SHORT).show()
        when (response.code) {
            //성공
            1000 -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            //최초
            1002 -> { changeFragment(2) }
            4000 -> { Log.d("GOOGLE", "Access-Token이 존재하지 않는 경우") }
            4001 -> { Log.d("GOOGLE", "유효하지 않은 AccessToken") }
            else -> { Log.d("GOOGLE", "로그인 실패 : 서버 오류") }
        }
    }
}