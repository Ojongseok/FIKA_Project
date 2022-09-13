package com.fika.fika_project.ui.main.mycourse.review

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.databinding.ItemReviewImgBinding
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity
import com.fika.fika_project.ui.main.mycourse.placeinfo.ReviewList
import com.fika.fika_project.utils.spfManager

class ReviewImgRVAdapter (private val reviewList: ReviewList, val context: Context) : RecyclerView.Adapter<ReviewImgRVAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemReviewImgBinding = ItemReviewImgBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val imgUrl = reviewList.imageUrls!![position]
        Glide.with(context).load(imgUrl).into(holder.binding.itemPlaceinfoReviewImgIv)

        val bottomDialog = ReviewImgFragment()

        holder.binding.itemPlaceinfoReviewImgIv.setOnClickListener {
            bottomDialog.show((context as PlaceinfoActivity).supportFragmentManager, bottomDialog.tag)
            spfManager.setImgUrl(imgUrl)
        }
    }

    override fun getItemCount(): Int = reviewList.imageUrls!!.size

    inner class ViewHolder(val binding: ItemReviewImgBinding):RecyclerView.ViewHolder(binding.root)
}