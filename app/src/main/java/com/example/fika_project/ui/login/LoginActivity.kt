package com.example.fika_project.ui.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.ApplicationClass.Companion.TAG
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityLoginBinding
import com.example.fika_project.ui.main.MainActivity
import com.example.fika_project.utils.spfManager
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import timber.log.Timber

class LoginActivity : AppCompatActivity(), LoginView {
    lateinit var binding : ActivityLoginBinding
    val service = LoginService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

//        var keyHash = Utility.getKeyHash(this)
//        Log.e(TAG, "해시 키 값 : ${keyHash}")

        initClickListener()
        setContentView(binding.root)

////         편의상 시작
        startActivity( Intent(this, MainActivity::class.java))
        finish()
    }

    private fun initClickListener(){
        binding.loginQuestionTv.setOnClickListener {
            val bottomDialog = LoginDialog()
            bottomDialog.show(supportFragmentManager, bottomDialog.tag)
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

                    Log.i(TAG,"카카오 로그인 토큰 : ${kakaoToken}")
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

                        Log.i(TAG,"카카오 로그인 토큰 : ${kakaoToken}")
                        service.tryKakaoLogin(kakaoToken)
                    }
                }
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                val kakaoToken = spfManager.getKakaoJwt()

                service.tryKakaoLogin(kakaoToken)
            }
        }
    }

    fun changeFragment(index: Int){
        when (index) {
            1->{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent) }

            2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.login_frm, Agree01Fragment())
                    .commitAllowingStateLoss()
            }

            3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.login_frm, Agree02Fragment())
                    .commitAllowingStateLoss()
            }
            4->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.login_frm, Agree03Fragment())
                    .commitAllowingStateLoss()
            }
            5->{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.login_frm, NicknameFragment())
                    .commitAllowingStateLoss()
            }
        }
    }


    override fun onLoading() {
//        TODO("Not yet implemented")
    }

    override fun onKakaoSuccess(response: AuthResponse) {
        Toast.makeText(this,"카카오 로그인",Toast.LENGTH_SHORT).show()
        when(response.code){
            //성공
            1000 -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            //최초
            1002 -> {
                changeFragment(2)
            }
            4000 -> { Log.d("KAKAOLOGIN", "Access-Token이 존재하지 않는 경우") }
            4001 -> { Log.d("KAKAOLOGIN", "유효하지 않은 AccessToken") }
            else ->  {
                Log.d("LOGIN", "로그인 실패 : 서버 오류")
            } }
    }
}