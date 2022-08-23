package com.example.fika_project.ui.main.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.databinding.ItemHomeScrapcourseBinding
import com.example.fika_project.databinding.ItemMyplaceBinding

class MyplaceRVAdapter (private val myplaceList: ArrayList<Myplace>) : RecyclerView.Adapter<MyplaceRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(myplace: Myplace)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMyplaceBinding =
            ItemMyplaceBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myplaceList[position])

        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(myplaceList[position]) }
    }

    override fun getItemCount(): Int = myplaceList.size

    inner class ViewHolder(val binding: ItemMyplaceBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(myplace: Myplace){
            binding.itemMyplaceIv.setImageResource(myplace.img!!)
            binding.itemMyplacePlaceWhereTv.text = myplace.placeWhere
            binding.itemMyplacePlaceWhereTv2.text = myplace.placeWhere02
            binding.itemMyplacePlaceTv.text = myplace.place
            binding.itemMyplacePlaceCateTv.text = myplace.placeCate
        }
    }

}