package com.example.fika_project.ui.main.mypage.myscrap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fika_project.databinding.ActivityMyScrapBinding
import com.example.fika_project.databinding.ActivityMySpotBinding

class MyScrapActivity : AppCompatActivity() {
    private var _Binding: ActivityMyScrapBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityMyScrapBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}