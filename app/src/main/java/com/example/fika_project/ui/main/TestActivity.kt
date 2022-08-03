package com.example.fika_project.ui.main

import android.R
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.databinding.ActivityTestBinding
import net.daum.mf.map.api.MapView

class TestActivity : AppCompatActivity() {
    private var _Binding: ActivityTestBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mapView = MapView(this)
        val mapViewContainer = findViewById<View>(com.example.fika_project.R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)


    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}