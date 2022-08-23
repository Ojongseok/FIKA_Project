package com.example.fika_project.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.databinding.ItemHomeCourseBinding

class CourseMakingRVAdapter(private val courseList: ArrayList<Course>) : RecyclerView.Adapter<CourseMakingRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(course: Course)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding:ItemHomeCourseBinding = ItemHomeCourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(courseList[position])
//        holder.itemView.setOnClickListener{
//        mItemClickListner.onItemClick(courseList[position]) }
    }

    override fun getItemCount(): Int = courseList.size

    inner class ViewHolder(val binding: ItemHomeCourseBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(course: Course){
            binding.itemHomeCourseIv.setImageResource(course.img!!)
            binding.itemHomeCourseNameTv.text = course.courseName
            binding.itemHomeCourseDramaNameTv.text = course.dramaName
            binding.itemHomeCourseFlagTv.text = course.flagName
        }
    }
}