package com.fika.fika_project.ui.main.home.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ItemHomePlacerankBinding
import com.fika.fika_project.databinding.SearchRecommendKeywordItemBinding

    class SearchRecommendAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.search_recommend_keyword_item,parent,false)

            return CustomViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val view = (holder as CustomViewHolder).itemView

        }
        inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
        override fun getItemCount() = 5
    }