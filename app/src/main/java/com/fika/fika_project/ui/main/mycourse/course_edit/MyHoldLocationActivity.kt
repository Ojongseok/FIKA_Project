package com.fika.fika_project.ui.main.mycourse.course_edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.ActivityMyHoldLocationBinding

class MyHoldLocationActivity : AppCompatActivity() {
    private var _Binding: ActivityMyHoldLocationBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityMyHoldLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myholdLocationRecyclerview.adapter = MyHoldLocationAdapter(this)
        binding.myholdLocationRecyclerview.layoutManager = LinearLayoutManager(this)
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}