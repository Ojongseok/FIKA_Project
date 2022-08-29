package com.example.fika_project.ui.main.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ItemHomeDramarankBinding
import com.example.fika_project.ui.main.explore.drama_info.DramaInfoActivity
import com.example.fika_project.utils.spfManager

class DramaRankRVAdapter(private val dramaRankList: ArrayList<dramaList>, val context: Context) : RecyclerView.Adapter<DramaRankRVAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeDramarankBinding = ItemHomeDramarankBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dramaRankList[position])
    }

    override fun getItemCount(): Int = dramaRankList.size

    inner class ViewHolder(val binding: ItemHomeDramarankBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(itemdramaRank: dramaList){
            val DramaId = itemdramaRank.dramaId
            spfManager.setDramaId(DramaId!!)

            binding.itemDramaRankTitleTv.text = itemdramaRank.dramaTitle.toString()
            Glide.with(context).load(itemdramaRank.thumbnailUrl).into(binding.itemDramaRankImgIv)

            itemView.setOnClickListener{
                val intent = Intent(context, DramaInfoActivity::class.java)
                context.startActivity(intent)
            }
        }
    }
}