package com.example.fika_project.ui.main.explore.drama_info

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.ui.main.explore.spotDataList
import com.example.fika_project.ui.main.hold_and_scrap.LocationHoldResponse
import com.example.fika_project.ui.main.hold_and_scrap.LocationHoldService
import com.example.fika_project.ui.main.hold_and_scrap.LocationHoldView
import com.example.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity
import kotlinx.android.synthetic.main.drama_info_course_item.view.*
import kotlinx.android.synthetic.main.drama_info_location_item.view.*

class DramaInfoLocationAdapter(private val locationList : ArrayList<spotDataList>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),LocationHoldView {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drama_info_location_item,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        var service = LocationHoldService(this,locationList[position].spotId!!)

        Glide.with(context).load(locationList[position].spotImageUrl).into(view.item_location_placerank_img_iv)
        view.item__location_placerank_where_tv.text = locationList[position].shortAddress
        view.item_location_placerank_title_tv.text = locationList[position].spotTitle
        view.item_location_placerank_category_tv.text = locationList[position].type


        if (locationList[position].scrapped!!) {
            view.item_location_placerank_flag_iv.setImageResource(R.drawable.ic_flag_on)
        } else {
            view.item_location_placerank_flag_iv.setImageResource(R.drawable.ic_flag_off)
        }

        view.item_location_placerank_flag_iv.setOnClickListener {
            service.tryLoadLocationHold(view.item_location_placerank_flag_iv)
        }
        view.item_home_placerank_layout.setOnClickListener {
            val intent = Intent(context, PlaceinfoActivity::class.java)
            context.startActivity(intent)
        }

    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = locationList.size

    override fun onExploreLoading() {
    }
    override fun onExploreSuccess(response: LocationHoldResponse, iv: ImageView) {
        when(response.code) {
            1012 -> {
                response.let {
                    iv.setImageResource(R.drawable.ic_flag_on)
                }
            }
            1013 -> {
                response.let {
                    iv.setImageResource(R.drawable.ic_flag_off)
                }
            }
        }
    }

    override fun onExploreFailure(code: Int, message: String) {
    }
}