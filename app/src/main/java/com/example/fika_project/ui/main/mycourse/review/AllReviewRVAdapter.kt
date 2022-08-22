package com.example.fika_project.ui.main.mycourse.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.databinding.ItemPlaceinfoReviewBinding

class AllReviewRVAdapter (private val reviewList: ArrayList<Review>) : RecyclerView.Adapter<AllReviewRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(review: Review)
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

        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(reviewList[position]) }
    }

    override fun getItemCount(): Int = reviewList.size

    inner class ViewHolder(val binding: ItemPlaceinfoReviewBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(review: Review){
            binding.itemPlaceinfoReviewNameTv.text = review.nickname
            binding.itemPlaceinfoReviewImg01.setImageResource(review.reviewImg!!)
            binding.itemPlaceinfoReviewContentsTv.text = review.contents
        }
    }

}