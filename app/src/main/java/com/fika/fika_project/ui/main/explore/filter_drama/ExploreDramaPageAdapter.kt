package com.fika.fika_project.ui.main.explore.filter_drama

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.ui.main.explore.drama_info.DramaInfoActivity
import com.fika.fika_project.utils.spfManager
import kotlinx.android.synthetic.main.dramalist_item.view.*

class ExploreDramaPageAdapter(val dramalist : ArrayList<result>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dramalist_item,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        val dramaId = dramalist[position].dramaId

        view.dramalist_dramaname.text = dramalist[position].dramaTitle
        Glide.with(context).load(dramalist[position].thumbnailUrl).into(view.dramalist_dramaimage)

        view.dramalist_dramaimage.setOnClickListener {
            if (position==0 || position==1) {
                val intent = Intent(context, DramaInfoActivity::class.java)
                intent.putExtra("number",dramaId)
                context.startActivity(intent)
            } else {
                Toast.makeText(context,"準備中です。",Toast.LENGTH_SHORT).show()
            }

        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = dramalist.size
}