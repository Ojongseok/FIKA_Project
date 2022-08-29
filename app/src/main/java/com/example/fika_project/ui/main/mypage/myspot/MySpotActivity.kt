package com.example.fika_project.ui.main.mypage.myspot

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityMySpotBinding
import kotlinx.android.synthetic.main.dramalist_item.view.*
import kotlinx.android.synthetic.main.item_myplace.view.*

class MySpotActivity : AppCompatActivity() {
    private var _Binding: ActivityMySpotBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityMySpotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myplaceBackIv.setOnClickListener { finish() }


//        binding.myplaceRv.layoutManager = LinearLayoutManager(this)
//        binding.myplaceRv.adapter = MySpotAdapter(mySpotList, this)
    }
}
class MySpotAdapter(val mySpotList : ArrayList<com.example.fika_project.ui.main.mypage.myspot.result>,val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_myplace_2,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        Glide.with(context).load(mySpotList[position].spotImageUrl).into(view.item_myplace_iv)
        view.item_myplace_place_tv.text = mySpotList[position].spotTitle
        view.item_myplace_place_cate_tv.text = mySpotList[position].type
        view.item_myplace_place_where_tv2.text = mySpotList[position].shortAddress

    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = mySpotList.size
}