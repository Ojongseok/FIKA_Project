package com.example.fika_project.ui.main.tour.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.ActivitySearchBinding
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : AppCompatActivity() {
    private var _Binding: ActivitySearchBinding? = null
    private val binding get() = _Binding!!
    var recentKeywordList : ArrayList<String> = ArrayList()
    val SearchRecentKeywordClass = SearchRecentKeywordClass()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recentKeywordList = SearchRecentKeywordClass.getStringArrayPref(applicationContext,"settings_item_json")

        binding.searchRecentKeywordRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.searchRecentKeywordRecyclerview.adapter = SearchRecentKeywordAdapter(this, recentKeywordList)

        binding.searchOkButton.setOnClickListener {
            if (recentKeywordList.size>=5) {
                recentKeywordList.removeAt(4)
            }
            recentKeywordList.add(0, search_contents_textview.text.toString())
            SearchRecentKeywordClass.setStringArrayPref(this,"settings_item_json",recentKeywordList)
            search_contents_textview.setText("")

        }
    }

}