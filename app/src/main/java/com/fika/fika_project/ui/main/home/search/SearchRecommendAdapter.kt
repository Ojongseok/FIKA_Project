package com.fika.fika_project.ui.main.home.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ItemHomePlacerankBinding
import com.fika.fika_project.databinding.SearchRecommendKeywordItemBinding
import kotlinx.android.synthetic.main.search_recent_keyword_item.view.*

class SearchRecommendAdapter(val context: Context, var recommendKeywordList : ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.search_recommend_keyword_item,viewGroup,false)

            return CustomViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val view = (holder as CustomViewHolder).itemView

            view.search_recent_keyword.text = recommendKeywordList[position]
        }
        inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
        override fun getItemCount() = 5
    }