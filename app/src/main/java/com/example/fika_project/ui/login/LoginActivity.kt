package com.example.fika_project.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.databinding.ActivityLoginBinding
import com.example.fika_project.ui.main.MainActivity

class LoginActivity : AppCompatActivity(),LoginView {
    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        initClickListener()
        setContentView(binding.root)

        // 편의상 시작
        startActivity(Intent(this,MainActivity::class.java))

        binding.loginSignUpTv.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }

    private fun initClickListener(){
        binding.loginLookTv.setOnClickListener(){
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}