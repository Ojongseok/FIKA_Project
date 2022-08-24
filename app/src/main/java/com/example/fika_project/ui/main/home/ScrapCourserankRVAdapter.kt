package com.example.fika_project.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ItemHomeScrapcourseBinding

class ScrapCourserankRVAdapter(private val scrapCourserankList: ArrayList<coursesSortBySaved>, val context: Context) : RecyclerView.Adapter<ScrapCourserankRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(scrapCourserank: coursesSortBySaved)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeScrapcourseBinding = ItemHomeScrapcourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(scrapCourserankList[position])

//        holder.itemView.setOnClickListener{
//            mItemClickListner.onItemClick(scrapCourserankList[position]) }
    }

    override fun getItemCount(): Int = scrapCourserankList.size

    inner class ViewHolder(val binding: ItemHomeScrapcourseBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(itemScrapCourserank: coursesSortBySaved){
            binding.itemHomeCoursescrapDramaTitleTv.text = itemScrapCourserank.dramaTitle
            binding.itemHomeCoursescrapWhereTv.text = itemScrapCourserank.baseAddress
            binding.childTitle.text = itemScrapCourserank.courseTitle
            binding.itemHomeCoursescrapInfoTv.text = itemScrapCourserank.spotTitleList.toString()
            binding.itemHomeCoursescrapNumberTv.text = itemScrapCourserank.courseSavedCount.toString()
            Glide.with(context).load(itemScrapCourserank.locageImageUrl).into(binding.itemHomeScrapcourseIv)

        }
    }

}