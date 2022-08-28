package com.example.fika_project.ui.main.explore.filter_course

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.ui.main.explore.CourseDetailDramaOthers
import com.example.fika_project.ui.main.explore.course
import kotlinx.android.synthetic.main.drama_info_course_item.view.*
import kotlinx.android.synthetic.main.explore_course_item_list.view.item_home_coursescrap_drama_title_tv

class ExploreCoursePageAdapter(val dramalist : ArrayList<course>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drama_info_course_item,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        view.item_home_coursescrap_drama_title_tv.text = dramalist[position].dramaTitle
        view.item_drama_coursescrap_where_tv.text = dramalist[position].baseAddress
        view.child_title.text = dramalist[position].courseTitle
        view.item_drama_coursescrap_number_tv.text = "총 " +dramalist[position].spotTitleList?.size.toString()+"곳"
        Glide.with(context).load(dramalist[position].locageImageUrl).into(view.drama_info_course_image)
        if (dramalist[position].scrapped!!) {
            view.drama_info_course_item_star.setImageResource(R.drawable.ic_star_on)
        } else {
            view.drama_info_course_item_star.setImageResource(R.drawable.ic_star_off)
        }
        view.drama_info_course_item_layout.setOnClickListener {
            val intent =Intent(context,CourseDetailDramaOthers::class.java)
            intent.putExtra("courseId",dramalist[position].courseId)
            context.startActivity(intent)
        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = dramalist.size
}