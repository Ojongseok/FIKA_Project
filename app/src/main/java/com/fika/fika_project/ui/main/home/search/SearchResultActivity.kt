package com.fika.fika_project.ui.main.home.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {
    private var _Binding: ActivitySearchResultBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
        setAdapter()
    }

    private fun setAdapter() {
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

    private fun setOnClickListener(){
        binding.searchBackBtn.setOnClickListener {
            finish()
        }
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}