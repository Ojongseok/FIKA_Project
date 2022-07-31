package com.example.fika_project.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.databinding.ItemHomerankBinding

class RankRVAdapter (private val rankList: ArrayList<Rank>) : RecyclerView.Adapter<RankRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(rank: Rank)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomerankBinding = ItemHomerankBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(rankList[position])
        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(rankList[position]) }
    }

    override fun getItemCount(): Int = rankList.size

    inner class ViewHolder(val binding: ItemHomerankBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(rank: Rank){
            binding.itemRankDramaTitleTv.text = rank.dramaName
            binding.itemRankArticleTitleTv.text = rank.articleTitle
            binding.itemRankCoverImgIv.setImageResource(rank.img!!)
        }
    }

}