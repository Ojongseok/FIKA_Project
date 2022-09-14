package com.fika.fika_project.ui.main.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ItemHomeCourseBinding
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.ui.main.explore.CourseDetailDramaOthers
import com.fika.fika_project.ui.main.explore.ExploreFragment
import com.fika.fika_project.ui.main.explore.courseList
import com.fika.fika_project.ui.main.mycourse.coursePreviewList
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_home_scrapcourse.view.*

class MyCourseRVAdapter(private val courseList: ArrayList<myCourseList>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    val HEADER =0
    val ITEM = 1
    val FOOTER = 2



    interface MyItemClickListener{
        fun onItemClick(course: myCourseList)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }

    private fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding:ItemHomeCourseBinding = ItemHomeCourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        if(courseList.size != 0){
            return when(viewType) {
                FOOTER -> FooterViewHolder(viewGroup.inflate(R.layout.footer_home_my_course_rv))
                else -> ItemViewHolder(binding)
            }
        }else{
            return when(viewType) {
                FOOTER -> FooterViewHolder(viewGroup.inflate(R.drawable.home_course_null_card_jp))
                else -> FooterViewHolder(viewGroup.inflate(R.layout.footer_home_my_course_null))
        }

         }
    }

    override fun getItemCount(): Int = courseList.size + 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> HEADER
            itemCount - 1 -> FOOTER
            else -> ITEM
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder){
            is FooterViewHolder -> {
                holder.itemView.setOnClickListener {
                    (context as MainActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ExploreFragment())
                        .commitAllowingStateLoss()
                    Snackbar.make(it, "드라마를 탐색하러 갑니다!", Snackbar.LENGTH_SHORT).setAction("Action", null).show()
                } }
            is ItemViewHolder -> {
                if(courseList.size == 0){
                    //
                }else{ holder.bind(courseList[position]) }

                }
            }
    }

    inner class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ItemViewHolder(val binding: ItemHomeCourseBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(itemCourse: myCourseList){
            Glide.with(context).load(itemCourse.locageImageUrl).into(binding.itemHomeCourseIv)
            binding.itemHomeCourseNameTv.text = itemCourse.courseTitle
            binding.itemHomeCourseDramaNameTv.text = itemCourse.dramaTitle
            binding.itemHomeCourseSpotTv.text = itemCourse.spotTitleList.toString()

            binding.itemHomeCourseTopCv.setOnClickListener {
                val intent = Intent(context, CourseDetailDramaOthers::class.java)
                intent.putExtra("courseId",itemCourse.courseId)
                context.startActivity(intent)
            }
        }
    }
}