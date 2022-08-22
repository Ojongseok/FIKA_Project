package com.example.fika_project.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityLoginBinding
import com.example.fika_project.retrofit.AuthResponse
import com.example.fika_project.ui.main.MainActivity

class LoginActivity : AppCompatActivity(),LoginView {
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        initClickListener()
        setContentView(binding.root)

//         편의상 시작
        startActivity(Intent(this,MainActivity::class.java))
    }

    private fun initClickListener(){
        binding.loginSignUpTv.setOnClickListener {
            changeFragment(2)
        }
    }

    fun changeFragment(index: Int){
        when (index) {
            1->{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent) }

            2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.login_frm, Signup01Fragment())
                    .commitAllowingStateLoss()
            }

            3 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.login_frm, Signup02Fragment())
                    .commitAllowingStateLoss()
            }
        }
    }

    override fun onLoginLoading() {
//        TODO("Not yet implemented")
    }

    override fun onLoginSuccess(response: AuthResponse) {
//        TODO("Not yet implemented")
    }

    override fun onLoginFailure(code: Int, message: String) {
//        TODO("Not yet implemented")
    }
}