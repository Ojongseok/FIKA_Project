package com.example.fika_project.ui.main.mycourse

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityReviewWriteBinding
import com.example.fika_project.databinding.ActivityVisitCompleteCourseBinding

class ReviewWriteActivity : AppCompatActivity() {
    private var _Binding: ActivityReviewWriteBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.reviewWriteImageSelectBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.review_write_fragment_container,ReviewCameraOrGallery()).commit()
        }
    }
}