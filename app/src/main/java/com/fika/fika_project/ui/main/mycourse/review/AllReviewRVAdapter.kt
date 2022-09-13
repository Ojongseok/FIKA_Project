package com.fika.fika_project.ui.main.mycourse.review

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ItemPlaceinfoReviewBinding
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity
import com.fika.fika_project.ui.main.mycourse.placeinfo.ReviewList
import com.fika.fika_project.utils.spfManager

class AllReviewRVAdapter (private val reviewList: ArrayList<ReviewList>, val context: Context) : RecyclerView.Adapter<AllReviewRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemMoreClick(position: Int)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPlaceinfoReviewBinding = ItemPlaceinfoReviewBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(reviewList[position])
        holder.binding.itemPlaceinfoReviewMoreIv.setOnClickListener {
            mItemClickListner.onItemMoreClick(position)
        }
    }


    override fun getItemCount(): Int = reviewList.size

    inner class ViewHolder(val binding: ItemPlaceinfoReviewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(itemReview: ReviewList){
            setAdapter(itemReview)

            binding.itemPlaceinfoReviewNameTv.text = itemReview.userNickname
            binding.itemPlaceinfoReviewContentsTv.text = itemReview.reviewContents
            binding.itemPlaceinfoReviewDateTv.text = itemReview.createAt

            spfManager.setReviewId(itemReview.reviewId)

            if(itemReview.imageUrls?.size == 0){
                binding.itemPlaceinfoReviewBottomImgRv.visibility = View.GONE
            } else{
                binding.itemPlaceinfoReviewBottomImgRv.visibility = View.VISIBLE

                binding.itemPlaceinfoReviewMoreIv.setOnClickListener {
                    (context as PlaceinfoActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.placeinfo_locate_frm, ReviewReportFragment())
                        .commitAllowingStateLoss() }
                }
            }

        private fun setAdapter(reviewList: ReviewList) {
            val reviewImgRVAdapter = ReviewImgRVAdapter(reviewList,context)
            binding.itemPlaceinfoReviewBottomImgRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.itemPlaceinfoReviewBottomImgRv.adapter = reviewImgRVAdapter
            binding.itemPlaceinfoReviewBottomImgRv.setHasFixedSize(false)
            }
        }
    }