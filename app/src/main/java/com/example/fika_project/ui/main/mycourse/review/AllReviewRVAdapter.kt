package com.example.fika_project.ui.main.mycourse.review

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.ItemPlaceinfoReviewBinding
import com.example.fika_project.ui.login.LoginDialog
import com.example.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity
import com.example.fika_project.ui.main.mycourse.placeinfo.ReviewList
import com.example.fika_project.utils.spfManager
import com.google.gson.Gson

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
            binding.itemPlaceinfoReviewNameTv.text = itemReview.userNickname
            binding.itemPlaceinfoReviewContentsTv.text = itemReview.reviewContents

            spfManager.setReviewId(itemReview.reviewId)

            if(itemReview.imageUrls?.size == 0){
                binding.itemPlaceinfoReviewBottomImgLayout.visibility = View.GONE
            } else{
                val bottomDialog = ReviewImgFragment()

                Glide.with(context).load(itemReview.imageUrls?.get(0)).into(binding.itemPlaceinfoReviewImg01)
                Glide.with(context).load(itemReview.imageUrls?.get(1)).into(binding.itemPlaceinfoReviewImg02)
                Glide.with(context).load(itemReview.imageUrls?.get(2)).into(binding.itemPlaceinfoReviewImg03)

                binding.itemPlaceinfoReviewImg01.setOnClickListener {
                    bottomDialog.show((context as PlaceinfoActivity).supportFragmentManager, bottomDialog.tag)
                    spfManager.setImgUrl(itemReview.imageUrls!!.get(0))
                }
                binding.itemPlaceinfoReviewImg02.setOnClickListener {
                    bottomDialog.show((context as PlaceinfoActivity).supportFragmentManager, bottomDialog.tag)
                    spfManager.setImgUrl(itemReview.imageUrls!!.get(1))
                }
                binding.itemPlaceinfoReviewImg03.setOnClickListener {
                    bottomDialog.show((context as PlaceinfoActivity).supportFragmentManager, bottomDialog.tag)
                    spfManager.setImgUrl(itemReview.imageUrls!!.get(2))
                }

                binding.itemPlaceinfoReviewMoreIv.setOnClickListener {
                    (context as PlaceinfoActivity).supportFragmentManager.beginTransaction()
                        .replace(R.id.placeinfo_locate_frm, ReviewReportFragment())
                        .commitAllowingStateLoss() }
                }
            }
        }
    }