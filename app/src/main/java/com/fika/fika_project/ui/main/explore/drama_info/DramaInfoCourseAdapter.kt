package com.fika.fika_project.ui.main.explore.drama_info

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.ui.main.explore.CourseDetailDrama
import com.fika.fika_project.ui.main.explore.courseList
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapResponse
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapService
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapView
import kotlinx.android.synthetic.main.drama_info_course_item.view.*
import kotlinx.android.synthetic.main.drama_info_course_item.view.child_title
import kotlinx.android.synthetic.main.drama_info_course_item.view.item_home_coursescrap_drama_title_tv
import kotlinx.android.synthetic.main.drama_info_location_item.view.*
import kotlinx.android.synthetic.main.item_home_scrapcourse.view.*
import kotlinx.android.synthetic.main.myhold_location_item_list.view.*
import java.net.URI
import java.util.logging.Level.parse

class DramaInfoCourseAdapter(val courselist : ArrayList<courseList>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),LocationScrapView {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_scrapcourse,parent,false)
        view.item_home_coursescrap_drama_star_iv.visibility = View.VISIBLE

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        val imgUri = courselist[position].locageImageUrl!!.trim()

        Glide.with(context).load(imgUri).disallowHardwareConfig().into(view.item_home_scrapcourse_iv)
        view.item_home_coursescrap_drama_title_tv.text = courselist[position].dramaTitle
        view.item_home_coursescrap_where_tv.text = courselist[position].baseAddress
        view.child_title.text = courselist[position].courseTitle
        view.item_home_coursescrap_info_tv.text = courselist[position].spotTitleList.toString()

        view.item_layout.setOnClickListener {
            val intent = Intent(context,CourseDetailDrama::class.java)
            intent.putExtra("courseId",courselist[position].courseId)
            context.startActivity(intent)
        }

        val service = LocationScrapService(this,courselist[position].courseId!!)

        if (courselist[position].scrapped!!) {
            view.item_home_coursescrap_drama_star_iv.setImageResource(R.drawable.ic_star_on)
        } else {
            view.item_home_coursescrap_drama_star_iv.setImageResource(R.drawable.ic_star_off)
        }

        view.item_home_coursescrap_drama_star_iv.setOnClickListener {
            service.tryLoadLocationScrap(view.item_home_coursescrap_drama_star_iv)
        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = courselist.size

    override fun onExploreLoading() {
    }

    override fun onExploreSuccess(response: LocationScrapResponse, iv: ImageView) {
        when(response.code) {
            1010 -> {
                response.let {
                    iv.setImageResource(R.drawable.ic_star_on)
                }
            }
            1011 -> {
                response.let {
                    iv.setImageResource(R.drawable.ic_star_off)
                }
            }
        }
    }

    override fun onExploreFailure(code: Int, message: String) {
    }
}