package com.example.fika_project.ui.main.explore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityCourseDetailDramaBinding
import com.example.fika_project.databinding.ActivityCourseDetailDramaOthersBinding
import com.example.fika_project.ui.main.explore.course_detail.CourseDetailResponse
import com.example.fika_project.ui.main.explore.course_detail.CourseDetailService
import com.example.fika_project.ui.main.explore.course_detail.CourseDetailView
import com.example.fika_project.ui.main.explore.course_detail.spotList
import com.example.fika_project.ui.main.explore.filter_drama.ExploreService
import kotlinx.android.synthetic.main.myhold_location_item_list.view.*

class CourseDetailDramaOthers : AppCompatActivity(),CourseDetailView {
    private var _Binding: ActivityCourseDetailDramaOthersBinding? = null
    private val binding get() = _Binding!!
    val service = CourseDetailService(this,intent.getIntExtra("courseId",0))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityCourseDetailDramaOthersBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.detailCourseTogetherRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CourseDetailTogetherOthersAdapter()
        }

        binding.courseDetailHoldBtn.setOnClickListener {
            startActivity(Intent(this,FolderSelectActivity::class.java))
            overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit)
        }
        service.tryLoadCourseDetail()
    }


    override fun onExploreLoading() {
    }
    override fun onExploreSuccess(response: CourseDetailResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    binding.detailCourseLocationRecyclerview.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = CourseDetailLocationOthersAdapter(it.result!!.spotList!!,context)
                    }
                    binding.courseDetailCourseTitle.text = it.result?.courseTitle
                }
            }
        }
    }
    override fun onExploreFailure(code: Int, message: String) {
    }
}

class CourseDetailLocationOthersAdapter(val locationList : ArrayList<spotList>,val context : Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myhold_location_item_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        Glide.with(context).load(locationList[position].spotImageUrl).into(view.course_detail_iv)
        view.course_detail_where_tv.text = locationList[position].shortAddress
        view.course_detail_category_tv.text = locationList[position].type
        view.course_detail_course_name.text = locationList[position].spotTitle


    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = locationList.size
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