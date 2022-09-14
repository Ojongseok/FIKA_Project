package com.fika.fika_project.ui.main.mycourse.course_edit.add_location

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.ui.main.explore.location
import com.fika.fika_project.ui.main.mypage.myspot.result
import kotlinx.android.synthetic.main.myhold_location_item_list.view.*
import kotlinx.android.synthetic.main.myhold_location_item_list.view.course_detail_category_tv
import kotlinx.android.synthetic.main.myhold_location_item_list.view.course_detail_iv
import kotlinx.android.synthetic.main.myhold_location_item_list.view.course_detail_where_tv
import kotlinx.android.synthetic.main.visit_complete_course_list.view.*

class MyHoldLocationAdapter(private val context : Context, val list : ArrayList<result>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myhold_location_item_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        Glide.with(context).load(list[position].spotImageUrl).into(view.course_detail_iv)
        view.course_detail_where_tv.text = list[position].shortAddress
        view.course_detail_category_tv.text = list[position].type
        view.hold_title_name_tv.text = list[position].spotTitle
        if (list[position].locage!!) {
            view.locage_tv.visibility = View.VISIBLE
        }
        view.myhold_checkbox_btn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {

            } else {

            }
        }

    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = list.size
}