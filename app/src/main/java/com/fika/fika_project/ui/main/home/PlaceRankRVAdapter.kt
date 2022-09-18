package com.fika.fika_project.ui.main.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ItemHomePlacerankBinding
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.ui.main.hold_and_scrap.LocationHoldResponse
import com.fika.fika_project.ui.main.hold_and_scrap.LocationHoldService
import com.fika.fika_project.ui.main.hold_and_scrap.LocationHoldView
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity
import com.fika.fika_project.utils.spfManager
import kotlinx.android.synthetic.main.drama_info_location_item.view.*
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

    inner class ViewHolder(val binding: ItemHomePlacerankBinding):RecyclerView.ViewHolder(binding.root),LocationHoldView{

        fun bind(itemPlaceRank: spotsSortBySaved){
            Glide.with(context).load(itemPlaceRank.spotImageUrl).into(binding.itemPlacerankImgIv)
            binding.itemPlacerankWhereTv.text = itemPlaceRank.shortAddress
            binding.itemPlacerankCategoryTv.text = itemPlaceRank.type
            binding.itemPlacerankTitleTv.text = itemPlaceRank.spotTitle
            binding.itemPlacerankWhereTv2.text = itemPlaceRank.shortAddress

            if (itemPlaceRank.scrapped!!) {
                binding.itemPlacerankFlagIv.setImageResource(R.drawable.ic_flag_on)
            } else {
                binding.itemPlacerankFlagIv.setImageResource(R.drawable.ic_flag_off)
            }
            binding.itemPlacerankFlagIv.setOnClickListener {
                val service = LocationHoldService(this,itemPlaceRank.spotId!!)
                service.tryLoadLocationHold(binding.itemPlacerankFlagIv)
            }

            itemView.setOnClickListener{
                val homeSpotId = itemPlaceRank.spotId

                val intent = Intent(context, PlaceinfoActivity::class.java)
                intent.putExtra("homeSpotId",homeSpotId)
                context.startActivity(intent)
            }
        }

        override fun onExploreLoading() {
        }

        override fun onExploreSuccess(response: LocationHoldResponse, iv: ImageView) {
            when(response.code) {
                1012 -> {
                    response.let {
                        iv.setImageResource(R.drawable.ic_flag_on)
                    }
                }
                1013 -> {
                    response.let {
                        iv.setImageResource(R.drawable.ic_flag_off)
                    }
                }
            }
        }

        override fun onExploreFailure(code: Int, message: String) {
        }
    }

}