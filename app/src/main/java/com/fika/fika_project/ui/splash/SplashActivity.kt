package com.fika.fika_project.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.fika.fika_project.databinding.ActivitySplashBinding
import com.fika.fika_project.ui.login.LoginActivity
import timber.log.Timber

class SplashActivity : AppCompatActivity(){
    lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTimber()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },200)
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}