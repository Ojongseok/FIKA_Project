package com.fika.fika_project.ui.main.mypage.myspot

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity
import kotlinx.android.synthetic.main.item_myplace.view.*
import kotlinx.android.synthetic.main.item_myplace.view.item_myplace_iv
import kotlinx.android.synthetic.main.item_myplace.view.item_myplace_place_cate_tv
import kotlinx.android.synthetic.main.item_myplace.view.item_myplace_place_tv
import kotlinx.android.synthetic.main.item_myplace.view.item_myplace_place_where_tv2
import kotlinx.android.synthetic.main.item_myplace_2.view.*

class MyspotRVAdapter (val mySpotList: ArrayList<result>,val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_myplace_2,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        Glide.with(context).load(mySpotList[position].spotImageUrl).into(view.item_myplace_iv)
        view.item_myplace_place_tv.text = mySpotList[position].spotTitle
        view.item_myplace_place_cate_tv.text = mySpotList[position].type
        view.item_myplace_place_where_tv2.text = mySpotList[position].shortAddress

        if(mySpotList[position].locage == true){
          view.item_myplace_locate_tag_iv.visibility = View.VISIBLE
        }else{
            view.item_myplace_locate_tag_iv.visibility = View.GONE
        }

        view.setOnClickListener{
            val homeSpotId = mySpotList[position].spotId

            val intent = Intent(context, PlaceinfoActivity::class.java)
            intent.putExtra("homeSpotId",homeSpotId)
            context.startActivity(intent)
        }


    }


    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)

    override fun getItemCount() = mySpotList.size
}