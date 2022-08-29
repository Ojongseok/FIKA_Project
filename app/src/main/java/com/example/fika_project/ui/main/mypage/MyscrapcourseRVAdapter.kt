package com.example.fika_project.ui.main.mypage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ItemHomeScrapcourseBinding

class MyscrapcourseRVAdapter (private val myscrapcourseList: ArrayList<MyScrap>,val context: Context) : RecyclerView.Adapter<MyscrapcourseRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(myscrapcourse: MyScrap)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeScrapcourseBinding =
            ItemHomeScrapcourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myscrapcourseList[position])

        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(myscrapcourseList[position]) }
    }

    override fun getItemCount(): Int = myscrapcourseList.size

    inner class ViewHolder(val binding: ItemHomeScrapcourseBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(itemScrapcourse: MyScrap){
            binding.itemHomeCoursescrapDramaTitleTv.text = itemScrapcourse.dramaTitle
            Glide.with(context).load(itemScrapcourse.locageImageUrl).into(binding.itemHomeScrapcourseIv)
            binding.childTitle.text = itemScrapcourse.courseTitle
        }
    }

}