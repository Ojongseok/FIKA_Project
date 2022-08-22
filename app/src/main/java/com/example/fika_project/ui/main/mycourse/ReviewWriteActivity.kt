package com.example.fika_project.ui.main.mycourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fika_project.databinding.ActivityReviewWriteBinding
import com.example.fika_project.databinding.ActivityVisitCompleteCourseBinding

class ReviewWriteActivity : AppCompatActivity() {
    private var _Binding: ActivityReviewWriteBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}