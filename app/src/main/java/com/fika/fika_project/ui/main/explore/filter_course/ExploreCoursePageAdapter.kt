package com.fika.fika_project.ui.main.explore.filter_course

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.ui.main.explore.CourseDetailDramaOthers
import com.fika.fika_project.ui.main.explore.course
import com.fika.fika_project.ui.main.explore.spotDataList
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapResponse
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapService
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapView
import kotlinx.android.synthetic.main.drama_info_course_item.view.*
import kotlinx.android.synthetic.main.drama_info_course_item.view.child_title
import kotlinx.android.synthetic.main.explore_course_item_list.view.item_home_coursescrap_drama_title_tv
import kotlinx.android.synthetic.main.item_home_scrapcourse.view.*

class ExploreCoursePageAdapter(val dramalist : ArrayList<course>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),LocationScrapView {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_scrapcourse,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        view.item_home_coursescrap_drama_title_tv.text = dramalist[position].dramaTitle
        view.item_home_coursescrap_where_tv.text = dramalist[position].baseAddress
        view.child_title.text = dramalist[position].courseTitle
        view.item_home_coursescrap_info_tv.text = dramalist[position].spotTitleList.toString()
        Glide.with(context).load(dramalist[position].locageImageUrl).into(view.item_home_scrapcourse_iv)

        if (dramalist[position].scrapped!!) {
            view.item_home_coursescrap_drama_star_iv.setImageResource(R.drawable.ic_star_on)
        } else {
            view.item_home_coursescrap_drama_star_iv.setImageResource(R.drawable.ic_star_off)
        }
        view.item_layout.setOnClickListener {
            val intent =Intent(context,CourseDetailDramaOthers::class.java)
            intent.putExtra("courseId",dramalist[position].courseId)
            context.startActivity(intent)
        }
        view.item_home_coursescrap_drama_star_iv.setOnClickListener {
            val service = LocationScrapService(this,dramalist[position].courseId!!)
            service.tryLoadLocationScrap(view.item_home_coursescrap_drama_star_iv)

        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = dramalist.size
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