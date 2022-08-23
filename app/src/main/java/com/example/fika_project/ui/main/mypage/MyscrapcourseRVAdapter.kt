package com.example.fika_project.ui.main.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.databinding.ItemHomeScrapcourseBinding

class MyscrapcourseRVAdapter (private val myscrapcourseList: ArrayList<Myscrapcourse>) : RecyclerView.Adapter<MyscrapcourseRVAdapter.ViewHolder>()
{
    interface MyItemClickListener{
        fun onItemClick(myscrapcourse: Myscrapcourse)
    }

    private lateinit var mItemClickListner: MyItemClickListener

    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListner = itemClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeScrapcourseBinding =
            ItemHomeScrapcourseBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myscrapcourseList[position])

        holder.itemView.setOnClickListener{
            mItemClickListner.onItemClick(myscrapcourseList[position]) }
    }

    override fun getItemCount(): Int = myscrapcourseList.size

    inner class ViewHolder(val binding: ItemHomeScrapcourseBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(myscrapcourse: Myscrapcourse){
            binding.itemHomeCoursescrapDramaTitleTv.text = myscrapcourse.dramaName
            binding.itemHomeScrapcourseIv.setImageResource(myscrapcourse.img!!)
            binding.childTitle.text = myscrapcourse.courseName
        }
    }

}