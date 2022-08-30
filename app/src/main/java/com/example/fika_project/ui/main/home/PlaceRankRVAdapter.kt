package com.example.fika_project.ui.main.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ItemHomePlacerankBinding
import com.example.fika_project.ui.main.explore.drama_info.DramaInfoActivity
import com.example.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity
import com.example.fika_project.utils.spfManager

class PlaceRankRVAdapter (private val placeRankList: ArrayList<spotsSortBySaved>, val context: Context) : RecyclerView.Adapter<PlaceRankRVAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomePlacerankBinding = ItemHomePlacerankBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(placeRankList[position])

    }

    override fun getItemCount(): Int = placeRankList.size

    inner class ViewHolder(val binding: ItemHomePlacerankBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(itemPlaceRank: spotsSortBySaved){

            val CourseId = itemPlaceRank.spotId
            spfManager.setCourseId(CourseId!!)

            Glide.with(context).load(itemPlaceRank.spotImageUrl).into(binding.itemPlacerankImgIv)
            binding.itemPlacerankWhereTv.text = itemPlaceRank.shortAddress
            binding.itemPlacerankCategoryTv.text = itemPlaceRank.type
            binding.itemPlacerankTitleTv.text = itemPlaceRank.spotTitle
            binding.itemPlacerankWhereTv2.text = itemPlaceRank.shortAddress

            itemView.setOnClickListener{
                val intent = Intent(context, PlaceinfoActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

}