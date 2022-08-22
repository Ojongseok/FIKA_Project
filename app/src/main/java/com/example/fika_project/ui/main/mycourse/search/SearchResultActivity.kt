package com.example.fika_project.ui.main.mycourse.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.ActivitySearchBinding
import com.example.fika_project.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {
    private var _Binding: ActivitySearchResultBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchResultDramaRecyclerview.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = SearchResultDramaAdapter(context)
        }
        binding.searchResultCourseRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SearchResultCourseAdapter(context)
        }
        binding.searchResultLocationRecyclerview.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = SearchResultLocationAdapter(context)
        }

    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}