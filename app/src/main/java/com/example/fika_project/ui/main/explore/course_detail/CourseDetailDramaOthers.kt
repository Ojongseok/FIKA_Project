package com.example.fika_project.ui.main.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityCourseDetailDramaBinding
import com.example.fika_project.databinding.ActivityCourseDetailDramaOthersBinding

class CourseDetailDramaOthers : AppCompatActivity() {
    private var _Binding: ActivityCourseDetailDramaOthersBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityCourseDetailDramaOthersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()

        binding.detailCourseLocationRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CourseDetailLocationOthersAdapter()
        }
        binding.detailCourseTogetherRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CourseDetailTogetherOthersAdapter()
        }

        binding.courseDetailHoldBtn.setOnClickListener {
            startActivity(Intent(this,FolderSelectActivity::class.java))
            overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit)
        }
    }

    private fun initData() {
    }
}

class CourseDetailLocationOthersAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myhold_location_item_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = 2
}
class CourseDetailTogetherOthersAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myhold_location_item_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView


    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = 4
}