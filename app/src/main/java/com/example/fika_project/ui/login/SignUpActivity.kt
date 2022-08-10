package com.example.fika_project.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fika_project.databinding.ActivitySearchBinding
import com.example.fika_project.databinding.ActivitySignUpBinding
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private var _Binding: ActivitySignUpBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupBackButton.setOnClickListener {
            finish()
        }
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}