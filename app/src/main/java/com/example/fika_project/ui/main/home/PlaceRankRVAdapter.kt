package com.example.fika_project.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.databinding.ItemHomePlacerankBinding

class PlaceRankRVAdapter (private val placeRankList: ArrayList<PlaceRank>) : RecyclerView.Adapter<PlaceRankRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(placeRank: PlaceRank)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomePlacerankBinding = ItemHomePlacerankBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(placeRankList[position])
        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(placeRankList[position]) }
    }

    override fun getItemCount(): Int = placeRankList.size

    inner class ViewHolder(val binding: ItemHomePlacerankBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(placeRank: PlaceRank){
            binding.itemPlacerankTitleTv.text = placeRank.title
            binding.itemPlacerankImgIv.setImageResource(placeRank.img!!)
        }
    }

}