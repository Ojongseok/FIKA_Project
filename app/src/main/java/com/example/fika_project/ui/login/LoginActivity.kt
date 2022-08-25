package com.example.fika_project.ui.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityLoginBinding
import com.example.fika_project.ui.main.MainActivity
import com.example.fika_project.utils.saveJwt
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import timber.log.Timber

class LoginActivity : AppCompatActivity(), LoginView {
    lateinit var binding : ActivityLoginBinding
    val service = LoginService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        initClickListener()
        setContentView(binding.root)

////         편의상 시작
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun initClickListener(){
        binding.loginQuestionTv.setOnClickListener {
            val bottomDialog = Signup01Dialog()
            bottomDialog.show(supportFragmentManager, bottomDialog.tag)
        }

        binding.loginKakaoIv.setOnClickListener {
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
                UserApiClient.instance.loginWithKakaoTalk(this@LoginActivity, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this@LoginActivity, callback = callback)
            }


        }
    }

    internal val callback : (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Timber.e("로그인 실패- $error")
        } else if (token != null) {
            UserApiClient.instance.me { user, error ->
                val kakaoId = user!!.id
                saveJwt(token.accessToken)
                service.tryKakaoLogin()
                Log.d("token",token.accessToken)

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
        }
    }


    override fun onLoading() {
//        TODO("Not yet implemented")
    }

    override fun onKakaoSuccess(response: LoginResponse) {
        Toast.makeText(this,"카카오 로그인",Toast.LENGTH_SHORT).show()
    }
}