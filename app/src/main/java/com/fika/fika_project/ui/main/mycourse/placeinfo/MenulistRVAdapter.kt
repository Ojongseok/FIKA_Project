package com.fika.fika_project.ui.main.mycourse.placeinfo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fika.fika_project.databinding.ItemPlaceinfoMenuBinding

class MenulistRVAdapter(private val MenuList: ArrayList<MenuList>, val context: Context) : RecyclerView.Adapter<MenulistRVAdapter.ViewHolder>()
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
            binding.placeinfoLocateMenuPriceTv.text = itemMenulist.menuPrice
        }
    }

}