package com.example.fika_project.ui.main.mycourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import com.example.fika_project.databinding.ActivityCourseInfoEditBinding
import com.example.fika_project.databinding.ActivityReviewWriteBinding

class CourseInfoEditActivity : AppCompatActivity() {
    private var _Binding: ActivityCourseInfoEditBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityCourseInfoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.courseInfoBackBtn.setOnClickListener { finish() }

        binding.courseInfoEditSwitchBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.switchOffTv2.visibility = View.INVISIBLE
                binding.switchOnTv.visibility = View.VISIBLE
            } else {
                binding.switchOnTv.visibility = View.INVISIBLE
                binding.switchOffTv2.visibility = View.VISIBLE
            }
        }

    }
}