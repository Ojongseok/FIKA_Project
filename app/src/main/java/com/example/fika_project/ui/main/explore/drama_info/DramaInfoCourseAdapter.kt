package com.example.fika_project.ui.main.explore.drama_info

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.ui.main.explore.CourseDetailDrama
import com.example.fika_project.ui.main.explore.CourseDetailDramaOthers
import com.example.fika_project.ui.main.explore.courseList
import kotlinx.android.synthetic.main.drama_info_course_item.view.*
import kotlinx.android.synthetic.main.drama_info_course_item.view.item_home_coursescrap_drama_title_tv

class DramaInfoCourseAdapter(val courselist : ArrayList<courseList>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drama_info_course_item,parent,false)
        view.drama_info_course_item_star.visibility = View.VISIBLE

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        Glide.with(context).load(courselist[position].locageImageUrl).into(view.drama_info_course_image)
        view.item_home_coursescrap_drama_title_tv.text = courselist[position].dramaTitle
        view.item_drama_coursescrap_where_tv.text = courselist[position].baseAddress
        view.child_title.text = courselist[position].courseTitle
        view.item_drama_coursescrap_number_tv.text = "총 " +courselist[position].spotTitleList?.size +"곳"

        view.drama_info_course_item_layout.setOnClickListener {
            val intent = Intent(context,CourseDetailDrama::class.java)
            intent.putExtra("courseId",courselist[position].courseId)
            context.startActivity(intent)
        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = courselist.size
}