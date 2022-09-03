package com.example.fika_project.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.ItemHomeCourseBinding
import com.example.fika_project.ui.main.MainActivity
import com.example.fika_project.ui.main.explore.ExploreFragment
import com.google.android.material.snackbar.Snackbar

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
//
//    private var tasks: ArrayList<myCourseList> = arrayListOf()

    private fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding:ItemHomeCourseBinding = ItemHomeCourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return when(viewType) {
            FOOTER -> FooterViewHolder(viewGroup.inflate(R.layout.footer_home_my_course_rv))
            HEADER -> bindViewHolder(binding)
            else -> ItemViewHolder(binding)
        }
    }

    override fun getItemCount(): Int = courseList.size + 2

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
            is ItemViewHolder -> { holder.bind(courseList[position]) }
            is bindViewHolder -> { holder.bind() }

            }
    }

    inner class bindViewHolder(val binding: ItemHomeCourseBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(){
            binding.itemHomeCourseNullCard.setOnClickListener {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, ExploreFragment())
                    .commitAllowingStateLoss()
                Snackbar.make(it, "드라마를 탐색하러 갑니다!", Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }

            binding.itemHomeCourseNullCard.visibility = View.VISIBLE
            binding.itemHomeCourseTopCv.visibility = View.GONE
            binding.itemHomeCourseBottomCv.visibility = View.GONE
        }
    }

    inner class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ItemViewHolder(val binding: ItemHomeCourseBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(itemCourse: myCourseList){
                Glide.with(context).load(itemCourse.locageImageUrl).into(binding.itemHomeCourseIv)
                binding.itemHomeCourseNameTv.text = itemCourse.courseTitle
                binding.itemHomeCourseDramaNameTv.text = itemCourse.dramaTitle
                binding.itemHomeCourseSpotTv.text = itemCourse.spotTitleList.toString()
        }
    }
}