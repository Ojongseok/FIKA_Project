package com.fika.fika_project.ui.main.home.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivitySearchBinding
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search_result.*

class SearchActivity : AppCompatActivity() {
    private var _Binding: ActivitySearchBinding? = null
    private val binding get() = _Binding!!
    var recentKeywordList : ArrayList<String> = ArrayList()
    var recommendKeywordList : ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivitySearchBinding.inflate(layoutInflater)

        recentKeywordList = SearchRecentKeywordClass.getStringArrayPref(applicationContext,"settings_item_json")

        initData()
        setOnClickListener()
        setAdapter()

        setContentView(binding.root)
    }

//    private fun setView(){
//        if (binding.searchEt.getText().length >= 2){
//            binding.searchOkButton.setImageResource(R.drawable.round_checkbox_on)
//            binding.searchOkButton.isEnabled = true
//        }else{
//            binding.searchOkButton.setImageResource(R.drawable.round_checkbox_off)
//            binding.searchOkButton.isEnabled = false
//        }

//    }

    private fun setOnClickListener(){
        binding.serachBackIv.setOnClickListener {
            finish() }


        binding.searchOkButton.setOnClickListener {
            if (recentKeywordList.size>=5) {
                recentKeywordList.removeAt(4)
            }
            recentKeywordList.add(0, search_et.text.toString())
            SearchRecentKeywordClass.setStringArrayPref(this,"settings_item_json",recentKeywordList)
            binding.searchEt.setText("")

            startActivity(Intent(this,SearchResultActivity::class.java))
        }
    }

    private fun setAdapter(){
        binding.searchRecentKeywordRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.searchRecentKeywordRecyclerview.adapter = SearchRecentKeywordAdapter(this, recentKeywordList)

        binding.searchReccomendRecyclerview.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL)
//        binding.searchReccomendRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.searchReccomendRecyclerview.adapter = SearchRecommendAdapter(this, recommendKeywordList)
    }

    private fun initData(){
        recommendKeywordList.add(0, "トッケビ")
        recommendKeywordList.add(1, "梨泰院クラス")
        recommendKeywordList.add(2, "パクソジュン")
        recommendKeywordList.add(3, "愛の不時着")
        recommendKeywordList.add(4, "彼女はきれいだった")
    }

    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}