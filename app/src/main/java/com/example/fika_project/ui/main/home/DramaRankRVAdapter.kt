package com.example.fika_project.ui.main.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ItemHomeDramarankBinding

class DramaRankRVAdapter(private val dramaRankList: ArrayList<dramaList>, val context: Context) : RecyclerView.Adapter<DramaRankRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(dramaRank: dramaList)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeDramarankBinding = ItemHomeDramarankBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dramaRankList[position])

        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(dramaRankList[position])
        }
    }

    override fun getItemCount(): Int = dramaRankList.size

    inner class ViewHolder(val binding: ItemHomeDramarankBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(itemdramaRank: dramaList){
            binding.itemDramaRankTitleTv.text = itemdramaRank.dramaTitle.toString()
            Glide.with(context).load(itemdramaRank.thumbnailUrl).into(binding.itemDramaRankImgIv)

        }
    }

}