package com.fika.fika_project.ui.main.mycourse.placeinfo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.databinding.ItemHomeDramarankBinding
import com.fika.fika_project.databinding.ItemPlaceinfoMenuBinding
import com.fika.fika_project.ui.main.explore.drama_info.DramaInfoActivity
import com.fika.fika_project.ui.main.home.DramaRankRVAdapter
import com.fika.fika_project.ui.main.home.dramaList
import com.fika.fika_project.utils.spfManager

class MenulistRVAdapter(private val MenuList: ArrayList<MenuList>, val context: Context,val money : String) : RecyclerView.Adapter<MenulistRVAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPlaceinfoMenuBinding = ItemPlaceinfoMenuBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(MenuList[position])
    }

    override fun getItemCount(): Int = MenuList.size

    inner class ViewHolder(val binding: ItemPlaceinfoMenuBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(itemMenulist: MenuList){
            binding.placeinfoLocateMenuTv.text = itemMenulist.menuName
            binding.placeinfoLocateMenuPriceTv.text = itemMenulist.menuPrice+"원"

            binding.placeinfoLocateMenuPriceIv.setOnClickListener {
                val dialog = MenuDialog(context,itemMenulist.menuName,itemMenulist.menuPrice,money)
                dialog.showDialog()
            }
        }
    }

}