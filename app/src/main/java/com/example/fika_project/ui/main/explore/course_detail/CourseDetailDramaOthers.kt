package com.example.fika_project.ui.main.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityCourseDetailDramaOthersBinding
import com.example.fika_project.ui.main.explore.course_detail.*
import okhttp3.internal.notify

class CourseDetailDramaOthers : AppCompatActivity(),CourseDetailView {
    private var _Binding: ActivityCourseDetailDramaOthersBinding? = null
    private val binding get() = _Binding!!
    lateinit var locationAdapter : CourseDetailLocationOthersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityCourseDetailDramaOthersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service = CourseDetailService(this,intent.getIntExtra("courseId",0))
        service.tryLoadCourseDetail()

    }

    private fun initData(initList: result) {
        binding.courseDetailCourseTitle.text = initList.courseTitle
        Glide.with(this).load(initList.locageSceneImageUrl).into(binding.courseDetailIv)
        binding.courseDetailLocageTiltle.text = initList.locageSceneDescribe
        binding.detailCourseHash.text = initList.hashTag
        binding.courseDetailDramaTitle.text = initList.dramaTitle

        Glide.with(this).load(initList.courseLocage?.spotImageUrl).into(binding.courseDetailIvLocation)
        binding.courseDetailWhereTv.text = initList.courseLocage?.shortAddress
        binding.courseDetailCategoryTv.text = initList.courseLocage?.type
        binding.courseDetailCourseName.text = initList.courseLocage?.spotTitle

    }

    private fun setOnClickEvent() {
        locationAdapter.setItemClickListener(object: CourseDetailLocationOthersAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int, checkStateList : Array<Boolean>) {
                super.onClick(view, position, checkStateList) // 미리 정의해둔 onClick 호출

                if (checkStateList.contains(true)) {
                    binding.courseDetailHoldBtn.setBackgroundResource(R.drawable.button_background_on)
                    binding.courseDetailHoldBtn.isClickable = true
                    binding.courseDetailHoldBtn.setOnClickListener {
                        startActivity(Intent(applicationContext, FolderSelectActivity::class.java))
                        overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit)
                    }
                }
            }
            override fun notClick(view: View, position: Int, checkStateList : Array<Boolean>) {
                super.notClick(view, position, checkStateList)
                if (!checkStateList.contains(true)) {
                    binding.courseDetailHoldBtn.setBackgroundResource(R.drawable.button_background_off)
                    binding.courseDetailHoldBtn.isClickable = false
                }

            }
        })
    }


    override fun onExploreLoading() {
    }
    override fun onExploreSuccess(response: CourseDetailResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    binding.detailCourseTogetherRecyclerview.apply {
                        layoutManager = LinearLayoutManager(context)
                        locationAdapter = CourseDetailLocationOthersAdapter(it.result?.spotList!!, context)
                        adapter = locationAdapter
                    }
                    binding.courseDetailCourseTitle.text = it.result?.courseTitle

                    setOnClickEvent()
                    initData(it.result!!)
                }
            }
        }
    }
    override fun onExploreFailure(code: Int, message: String) {
    }
}

