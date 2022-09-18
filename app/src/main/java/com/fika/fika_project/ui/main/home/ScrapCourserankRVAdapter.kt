package com.fika.fika_project.ui.main.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ItemHomeScrapcourseBinding
import com.fika.fika_project.ui.main.explore.CourseDetailDramaOthers
import com.fika.fika_project.ui.main.hold_and_scrap.LocationHoldService
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapResponse
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapService
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapView
import kotlinx.android.synthetic.main.item_home_scrapcourse.view.*
import kotlinx.android.synthetic.main.myhold_location_item_list.view.*

class ScrapCourserankRVAdapter(private val scrapCourserankList: ArrayList<coursesSortBySaved>, val context: Context)
    : RecyclerView.Adapter<ScrapCourserankRVAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeScrapcourseBinding = ItemHomeScrapcourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(scrapCourserankList[position])
    }


    override fun getItemCount(): Int = scrapCourserankList.size

    inner class ViewHolder(val binding: ItemHomeScrapcourseBinding):RecyclerView.ViewHolder(binding.root),LocationScrapView{
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
            if (itemScrapCourserank.scrapped!!) {
                binding.itemHomeCoursescrapDramaStarIv.setImageResource(R.drawable.ic_star_on)
            } else {
                binding.itemHomeCoursescrapDramaStarIv.setImageResource(R.drawable.ic_star_off)
            }
            binding.itemHomeCoursescrapDramaStarIv.setOnClickListener {
                val service = LocationScrapService(this,itemScrapCourserank.courseId!!)
                service.tryLoadLocationScrap(binding.itemHomeCoursescrapDramaStarIv)
            }

        }

        override fun onExploreLoading() {
        }

        override fun onExploreSuccess(response: LocationScrapResponse, iv: ImageView) {
            when(response.code) {
                1010 -> {
                    response.let {
                        iv.setImageResource(R.drawable.ic_star_on)
                    }
                }
                1011 -> {
                    response.let {
                        iv.setImageResource(R.drawable.ic_star_off)
                    }
                }
            }
        }

        override fun onExploreFailure(code: Int, message: String) {
        }
    }

}