package com.fika.fika_project.ui.main.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.databinding.ItemHomeScrapcourseBinding
import com.fika.fika_project.ui.main.explore.CourseDetailDramaOthers

class ScrapCourserankRVAdapter(private val scrapCourserankList: ArrayList<coursesSortBySaved>, val context: Context) : RecyclerView.Adapter<ScrapCourserankRVAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeScrapcourseBinding = ItemHomeScrapcourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(scrapCourserankList[position])
    }

    override fun getItemCount(): Int = scrapCourserankList.size

    inner class ViewHolder(val binding: ItemHomeScrapcourseBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(itemScrapCourserank: coursesSortBySaved){
            binding.itemHomeCoursescrapDramaTitleTv.text = itemScrapCourserank.dramaTitle
            binding.itemHomeCoursescrapWhereTv.text = itemScrapCourserank.baseAddress
            binding.childTitle.text = itemScrapCourserank.courseTitle
            binding.itemHomeCoursescrapInfoTv.text = itemScrapCourserank.spotTitleList.toString()
            Glide.with(context).load(itemScrapCourserank.locageImageUrl).into(binding.itemHomeScrapcourseIv)

            binding.itemLayout.setOnClickListener {
                val intent = Intent(context, CourseDetailDramaOthers::class.java)
                intent.putExtra("courseId",itemScrapCourserank.courseId)
                context.startActivity(intent)
            }

        }
    }

}