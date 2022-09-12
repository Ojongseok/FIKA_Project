package com.fika.fika_project.ui.main.home.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ItemHomeDramarankBinding
import com.fika.fika_project.databinding.ItemHomeScrapcourseBinding

class SearchResultCourseAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemHomeScrapcourseBinding = ItemHomeScrapcourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        binding.itemHomeCoursescrapDramaStarIv.visibility = View.VISIBLE

        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: ItemHomeScrapcourseBinding):RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as ViewHolder).itemView

    }

    override fun getItemCount() = 3
}