package com.example.fika_project.ui.main.explore.drama_info

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.ui.main.explore.spotDataList
import kotlinx.android.synthetic.main.drama_info_course_item.view.*
import kotlinx.android.synthetic.main.drama_info_location_item.view.*

class DramaInfoLocationAdapter(val locationList : ArrayList<spotDataList>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drama_info_location_item,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        Glide.with(context).load(locationList[position].spotImageUrl).into(view.item_location_placerank_img_iv)
        view.item__location_placerank_where_tv.text = locationList[position].shortAddress
        view.item_location_placerank_title_tv.text = locationList[position].spotTitle
        view.item_location_placerank_category_tv.text = locationList[position].type

        view.item_home_placerank_layout.setOnClickListener {

        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = locationList.size
}