package com.example.fika_project.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.ItemHomeCourseBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_home_course.view.*

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

    private var tasks: ArrayList<myCourseList> = arrayListOf()

    private fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding:ItemHomeCourseBinding = ItemHomeCourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return when(viewType) {
            FOOTER -> FooterViewHolder(viewGroup.inflate(R.layout.footer_home_my_course_rv))
            else ->  ItemViewHolder(binding)
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
                Snackbar.make(it, "Footer is Clicked!!", Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            }
        }
        else -> {

            if (tasks.size!== 0) {
                val item = tasks[position]
            }

            // 내부 데이터를 사용하여 각 아이템 값 설정
            holder.itemView.apply {

            }

            }
        }
    }

    inner class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class ItemViewHolder(val binding: ItemHomeCourseBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(itemCourse: myCourseList){
            //코스 없을 경우
//            val urlString = itemCourse.locageImageUrl
//            if(urlString?.isEmpty()!!){
//                binding.itemHomeCourseIv?.setImageResource(R.color.sub_yellow)
//            } else {
//                binding.itemHomeCourseIv?.visibility = View.GONE }

//            Glide.with().load(itemCourse.locageImageUrl).into(binding.itemHomeCourseIv)
            binding.itemHomeCourseNameTv.text = itemCourse.courseTitle
            binding.itemHomeCourseDramaNameTv.text = itemCourse.dramaTitle
            binding.itemHomeCourseSpotTv.text = itemCourse.spotTitleList.toString()
        }
    }

}