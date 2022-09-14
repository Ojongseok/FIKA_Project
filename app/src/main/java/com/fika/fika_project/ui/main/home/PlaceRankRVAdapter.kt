package com.fika.fika_project.ui.main.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.databinding.ItemHomePlacerankBinding
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity
import com.fika.fika_project.utils.spfManager
import timber.log.Timber

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
            Glide.with(context).load(itemPlaceRank.spotImageUrl).into(binding.itemPlacerankImgIv)
            binding.itemPlacerankWhereTv.text = itemPlaceRank.shortAddress
            binding.itemPlacerankCategoryTv.text = itemPlaceRank.type
            binding.itemPlacerankTitleTv.text = itemPlaceRank.spotTitle
            binding.itemPlacerankWhereTv2.text = itemPlaceRank.shortAddress

            itemView.setOnClickListener{
                val homeSpotId = itemPlaceRank.spotId

                val intent = Intent(context, PlaceinfoActivity::class.java)
                intent.putExtra("homeSpotId",homeSpotId)
                context.startActivity(intent)
            }
        }
    }

}