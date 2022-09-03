package com.fika.fika_project.ui.main.mycourse.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.ActivitySearchBinding
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    private var _Binding: ActivitySearchBinding? = null
    private val binding get() = _Binding!!
    var recentKeywordList : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recentKeywordList = SearchRecentKeywordClass.getStringArrayPref(applicationContext,"settings_item_json")

        binding.searchRecentKeywordRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.searchRecentKeywordRecyclerview.adapter = SearchRecentKeywordAdapter(this, recentKeywordList)

        binding.searchReccomendRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.searchReccomendRecyclerview.adapter = SearchRecommendAdapter(this)

        binding.searchOkButton.setOnClickListener {
            if (recentKeywordList.size>=5) {
                recentKeywordList.removeAt(4)
            }
            recentKeywordList.add(0, search_contents_textview.text.toString())
            SearchRecentKeywordClass.setStringArrayPref(this,"settings_item_json",recentKeywordList)
            binding.searchContentsTextview.setText("")

            startActivity(Intent(this,SearchResultActivity::class.java))
        }
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}