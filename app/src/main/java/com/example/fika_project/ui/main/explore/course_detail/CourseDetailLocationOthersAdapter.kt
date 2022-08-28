package com.example.fika_project.ui.main.explore.course_detail

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.ui.main.explore.CourseDetailDramaOthers
import com.example.fika_project.ui.main.explore.FolderSelectActivity
import kotlinx.android.synthetic.main.activity_course_detail_drama_others.*
import kotlinx.android.synthetic.main.myhold_location_item_list.view.*

class CourseDetailLocationOthersAdapter(val locationList: ArrayList<spotList>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener : OnItemClickListener
    var checkStateList = Array<Boolean>(locationList.size) { i -> false }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myhold_location_item_list,parent,false)

        return CustomViewHolder(view)
    }
    interface OnItemClickListener {
        fun onClick(view: View, position: Int, list : Array<Boolean>) {
        }
        fun notClick(view:View,position: Int,  list : Array<Boolean>) {
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        Glide.with(context).load(locationList[position].spotImageUrl).into(view.course_detail_iv)
        view.course_detail_where_tv.text = locationList[position].shortAddress
        view.course_detail_category_tv.text = locationList[position].type
        view.course_detail_course_name.text = locationList[position].spotTitle

        view.myhold_checkbox_btn.setOnCheckedChangeListener { compoundButton, checked ->
            if (checked) {
                checkStateList[position] = true
                itemClickListener.onClick(view, position,checkStateList)
            } else {
                checkStateList[position] = false
                itemClickListener.notClick(view, position,checkStateList)
            }
        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = locationList.size

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
}
