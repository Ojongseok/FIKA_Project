package com.example.fika_project.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.databinding.ItemHomeScrapcourseBinding

class ScrapCourserankRVAdapter (private val scrapCourserankList: ArrayList<ScrapCourserank>) : RecyclerView.Adapter<ScrapCourserankRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(scrapCourserank: ScrapCourserank)
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
        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(scrapCourserankList[position]) }
    }

    override fun getItemCount(): Int = scrapCourserankList.size

    inner class ViewHolder(val binding: ItemHomeScrapcourseBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(scrapCourserank: ScrapCourserank){
            binding.itemHomeCoursescrapDramaTitleTv.text = scrapCourserank.dramaName
            binding.itemHomeScrapcourseIv.setImageResource(scrapCourserank.img!!)
        }
    }

}