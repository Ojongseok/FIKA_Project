package com.fika.fika_project.ui.main.mycourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.ActivityVisitCompleteCourseBinding

class VisitCompleteCourse : AppCompatActivity() {
    private var _Binding: ActivityVisitCompleteCourseBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityVisitCompleteCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.visitCompleteCourseRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.visitCompleteCourseRecyclerview.adapter = VisitCompleteCourseAdapter(this)

    }
}