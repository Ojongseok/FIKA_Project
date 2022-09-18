package com.fika.fika_project.ui.main.explore

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityCourseDetailDramaBinding
import com.fika.fika_project.retrofit.AddCourseDTO
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.ui.main.explore.course_detail.*
import com.fika.fika_project.ui.main.hold_and_scrap.LocationHoldResponse
import com.fika.fika_project.ui.main.hold_and_scrap.LocationHoldService
import com.fika.fika_project.ui.main.hold_and_scrap.LocationHoldView

class CourseDetailDrama : AppCompatActivity(),CourseDetailView,LocationHoldView {
    private var _Binding: ActivityCourseDetailDramaBinding? = null
    private val binding get() = _Binding!!
    lateinit var dramaAdapter: CourseDetailDramaAdapter
    var courseId = 0
    var addCourseDTO = AddCourseDTO()
    lateinit var spotList :ArrayList<spotList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityCourseDetailDramaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service = CourseDetailService(this,intent.getIntExtra("courseId",0))
        courseId = intent.getIntExtra("courseId",0)


        binding.courseDetailDramaBackBtn.setOnClickListener {
            finish()
        }
        binding.courseDetailHomeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent)
            finish()
        }

        service.tryLoadCourseDetail()
    }
    private fun initData(initList: result) {
//        binding.courseDetailLocageTiltleByDrama.text = initList.courseTitle
        Glide.with(this).load(initList.locageSceneImageUrl).into(binding.courseDetailIvByDrama)
        binding.courseDetailLocageTiltleByDrama.text = initList.locageSceneDescribe
        binding.detailCourseHashTvByDrama.text = initList.hashTag

        Glide.with(this).load(initList.courseLocage?.spotImageUrl).into(binding.courseDetailIv)
        binding.courseDetailWhereTv.text = initList.courseLocage?.shortAddress
        binding.courseDetailCategoryTv.text = initList.courseLocage?.type
        binding.courseDetailCourseName.text = initList.courseLocage?.spotTitle
        binding.othersStarCountTv.text = initList.courseSavedCount.toString()
        binding.courseDetailDramaNameTv.text = initList.dramaTitle

        binding.courseDetailLocationFlagBtn.setOnClickListener {
            var service = LocationHoldService(this,initList.courseLocage?.spotId!!)
            service.tryLoadLocationHold(binding.courseDetailLocationFlagBtn)
        }
        addCourseDTO.baseCourseId = courseId
        addCourseDTO.locageSpotId = initList.courseLocage?.spotId
    }

    private fun setOnClickEvent() {
        dramaAdapter.setItemClickListener(object: CourseDetailDramaAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int, list: Array<Boolean>, count: Int) {
                super.onClick(view, position,list,count) // 미리 정의해둔 onClick 호출
                binding.courseDetailDramaCheckCount.text = "+" + count.toString()
                if (list.contains(true)) {
                    binding.courseDetailHoldBtn.setBackgroundResource(R.drawable.button_background_on)
                    binding.courseDetailHoldBtn.isClickable = true
                    binding.courseDetailHoldBtn.setOnClickListener {
                        val checkSpot = ArrayList<Int>()
                        for (i in 0 until list.size) {
                            if (list[i]) {
                                checkSpot.add(spotList[i].spotId!!)
                            }
                        }
                        addCourseDTO.spotIdList = checkSpot
                        val intent = Intent(applicationContext, FolderSelectActivity::class.java)
                        intent.putExtra("courseId",courseId)
                        intent.putExtra("addCourseDTO",addCourseDTO)
                        startActivity(intent)
                        overridePendingTransition(R.anim.slide_up_enter, R.anim.slide_up_exit)
                    }
                }
            }
            override fun notClick(view: View, position: Int, list : Array<Boolean>,count:Int) {
                super.notClick(view, position, list,count)
                binding.courseDetailDramaCheckCount.text = "+" + count.toString()
                if (!list.contains(true)) {
                    binding.courseDetailHoldBtn.setBackgroundResource(R.drawable.button_background_off)
                    binding.courseDetailHoldBtn.isClickable = false
                }

            }
        })
    }

    override fun onExploreSuccess(response: CourseDetailResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    binding.courseDetailDramaPr.visibility = View.GONE
                    binding.detailCourseTogetherRecyclerview.apply {
                        layoutManager = LinearLayoutManager(context)
                        dramaAdapter = CourseDetailDramaAdapter(it.result?.spotList!!, context)
                        adapter = dramaAdapter
                        spotList = it.result?.spotList
                    }

                    setOnClickEvent()
                    initData(it.result!!)
                }
            }

        }
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }

    override fun onExploreLoading() {
        binding.courseDetailDramaPr.visibility = View.VISIBLE
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
