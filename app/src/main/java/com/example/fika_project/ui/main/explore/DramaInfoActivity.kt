package com.example.fika_project.ui.main.explore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.ActivityDramaInfoBinding
import net.daum.mf.map.api.MapView

class DramaInfoActivity : AppCompatActivity() {
    private var _Binding: ActivityDramaInfoBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityDramaInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dramaInfoLocationRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.dramaInfoLocationRecyclerview.adapter = DramaInfoLocationAdapter(this)

        binding.dramaInfoCourseRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.dramaInfoCourseRecyclerview.adapter = DramaInfoCourseAdapter(this)

        val mapView = MapView(this)
        val mapViewContainer = findViewById<View>(com.example.fika_project.R.id.drama_info_mapview) as ViewGroup
        mapViewContainer.addView(mapView)

    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}