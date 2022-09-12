package com.fika.fika_project.ui.main.mypage.mycourse

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ItemHomeScrapcourseBinding
import com.fika.fika_project.ui.main.mypage.MyScrap

class MyscrapcourseRVAdapter (private val myscrapcourseList: ArrayList<MyScrap>, val context: Context) : RecyclerView.Adapter<MyscrapcourseRVAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeScrapcourseBinding =
            ItemHomeScrapcourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        Log.d("myscrapsize",itemCount.toString())
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myscrapcourseList[position])
    }

    override fun getItemCount(): Int = myscrapcourseList.size

    inner class ViewHolder(val binding: ItemHomeScrapcourseBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(itemScrapcourse: MyScrap){
            binding.itemHomeCoursescrapDramaStarIv.setImageResource(R.drawable.star_yellow)

            Glide.with(context).load(itemScrapcourse.locageImageUrl).into(binding.itemHomeScrapcourseIv)
            binding.itemHomeCoursescrapDramaTitleTv.text = itemScrapcourse.dramaTitle
            binding.childTitle.text = itemScrapcourse.courseTitle
            binding.itemHomeCoursescrapWhereTv.text = itemScrapcourse.baseAddress
            binding.itemHomeCoursescrapInfoTv.text = itemScrapcourse.spotTitleList.toString()
        }
    }

}