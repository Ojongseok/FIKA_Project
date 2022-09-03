package com.fika.fika_project.ui.main.explore.drama_info

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.ui.main.explore.spotDataList
import kotlinx.android.synthetic.main.activity_search.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class PagerRecyclerAdapter(val spotlist : ArrayList<spotDataList>, val context : Context) : RecyclerView.Adapter<PagerRecyclerAdapter.PagerViewHolder>() {
    private lateinit var itemClickListener : OnItemClickListener
    interface OnItemClickListener {
        fun onClick(view: View, position: Int) {
            // recyclerview의 item을 클릭했을 때 수행할 동작
        }
    }

    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleName = itemView.map_title_name
        private val map_tv_1 = itemView.map_where_tv1
        private val map_tv_2 = itemView.map_where_tv2
        private val mapIv = itemView.map_iv
        fun bind(spotlist: spotDataList, position: Int) {
            titleName.text = spotlist.spotTitle
            map_tv_1.text = spotlist.shortAddress
            map_tv_2.text = spotlist.type
            Glide.with(context).load(spotlist.spotImageUrl).into(mapIv)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return PagerViewHolder(view)
    }
    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(spotlist[position], position)

        holder.itemView.map_top_layout.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    override fun getItemCount(): Int = spotlist.size

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

}