package com.example.fika_project.ui.main.mycourse

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.R
import kotlinx.android.synthetic.main.drama_info_course_item.view.*
import kotlinx.android.synthetic.main.visit_complete_course_list.view.*

class VisitCompleteCourseAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.visit_complete_course_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        view.visit_complete_review_write_btn.setOnClickListener {
            context.startActivity(Intent(context.applicationContext,ReviewWriteActivity::class.java))
        }

    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = 6
}