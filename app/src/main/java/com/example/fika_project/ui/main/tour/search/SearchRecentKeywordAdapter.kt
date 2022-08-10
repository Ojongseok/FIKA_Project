package com.example.fika_project.ui.main.tour.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.R
import kotlinx.android.synthetic.main.search_recent_keyword_item.view.*

class SearchRecentKeywordAdapter(val context : Context, var recentKeywordList : ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_recent_keyword_item,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        view.search_recent_keyword.text = recentKeywordList[position]
        view.search_recent_remove_button.setOnClickListener {
            recentKeywordList.removeAt(position)
            SearchRecentKeywordClass.setStringArrayPref(context,"settings_item_json",recentKeywordList)
            notifyDataSetChanged()
        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = recentKeywordList.size
}