package com.example.fika_project.ui.main.tour

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.R
import kotlinx.android.synthetic.main.fragment_tour.view.*
import kotlinx.android.synthetic.main.tour_recyclerview_dramalist_item.view.*

class TourRecyclerviewAdapter(val frg : Fragment): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tour_recyclerview_dramalist_item,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tour_dramalist_dramaimage.setOnClickListener {
            frg.parentFragmentManager.beginTransaction().replace(R.id.tour_container,TourActorSelectFragment()).addToBackStack(null).commit()


        }
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = 11
}