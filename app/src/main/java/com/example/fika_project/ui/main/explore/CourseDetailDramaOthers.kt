package com.example.fika_project.ui.main.explore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fika_project.databinding.ActivityCourseDetailDramaBinding
import com.example.fika_project.databinding.ActivityCourseDetailDramaOthersBinding

class CourseDetailDramaOthers : AppCompatActivity() {
    private var _Binding: ActivityCourseDetailDramaOthersBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityCourseDetailDramaOthersBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}