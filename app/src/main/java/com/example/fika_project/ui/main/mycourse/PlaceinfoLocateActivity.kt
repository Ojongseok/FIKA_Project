package com.example.fika_project.ui.main.mycourse

import android.os.Bundle
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.databinding.ActivityPlaceinfoLocateBinding

class PlaceinfoLocateActivity: AppCompatActivity() {
    lateinit var binding: ActivityPlaceinfoLocateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceinfoLocateBinding.inflate(layoutInflater)
        initView()

        setContentView(binding.root)
    }

    private fun initView() {
        binding.placeinfoLocateUpBtn.setOnClickListener {
                binding.placeinfoLocateSv.fullScroll(ScrollView.FOCUS_UP)
        }

        binding.placeinfoLocateAllReviewBtn.setOnClickListener {
        }
    }
 }