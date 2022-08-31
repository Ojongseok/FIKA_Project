package com.example.fika_project.ui.main.explore

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityCourseDetailDramaBinding
import com.example.fika_project.ui.main.SpinnerModel
import com.example.fika_project.ui.main.explore.course_detail.*
import com.example.fika_project.ui.main.hold_and_scrap.LocationHoldResponse
import com.example.fika_project.ui.main.hold_and_scrap.LocationHoldService
import com.example.fika_project.ui.main.hold_and_scrap.LocationHoldView
import kotlinx.android.synthetic.main.item_spinner.view.*
import kotlinx.android.synthetic.main.myhold_location_item_list.view.*

class CourseDetailDrama : AppCompatActivity(),CourseDetailView,LocationHoldView {
    private var _Binding: ActivityCourseDetailDramaBinding? = null
    private val binding get() = _Binding!!
    private val listOfYear = ArrayList<SpinnerModel>()
    lateinit var dramaAdapter: CourseDetailDramaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityCourseDetailDramaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service = CourseDetailService(this,intent.getIntExtra("courseId",0))

        binding.courseDetailHoldBtn.setOnClickListener {
            startActivity(Intent(this,FolderSelectActivity::class.java))
            overridePendingTransition(R.anim.slide_up_enter,R.anim.slide_up_exit)
        }
        binding.courseDetailDramaBackBtn.setOnClickListener {
            finish()
        }

        binding.courseDetailDramaNameBtn.setOnClickListener {
            val menuList =arrayOf("하나","둘","셋")
            val dialog = AlertDialog.Builder(this,android.R.style.Theme_DeviceDefault_Light_Dialog_Alert)
            dialog.setTitle("정렬")
            dialog.setItems(menuList,DialogInterface.OnClickListener {dialogInterface, i ->
                Toast.makeText(this,menuList[i].toString(),Toast.LENGTH_SHORT).show()
            })
            dialog.show()
        }

        service.tryLoadCourseDetail()
    }
    private fun initData(initList: result) {
        binding.courseDetailLocageTiltleByDrama.text = initList.courseTitle
        Glide.with(this).load(initList.locageSceneImageUrl).into(binding.courseDetailIvByDrama)
        binding.courseDetailLocageTiltleByDrama.text = initList.locageSceneDescribe
        binding.detailCourseHashTvByDrama.text = initList.hashTag

        Glide.with(this).load(initList.courseLocage?.spotImageUrl).into(binding.courseDetailIv)
        binding.courseDetailWhereTv.text = initList.courseLocage?.shortAddress
        binding.courseDetailCategoryTv.text = initList.courseLocage?.type
        binding.courseDetailCourseName.text = initList.courseLocage?.spotTitle
        binding.othersStarCountTv.text = initList.courseSavedCount.toString()

        binding.courseDetailLocationFlagBtn.setOnClickListener {
            var service = LocationHoldService(this,initList.courseLocage?.spotId!!)
            service.tryLoadLocationHold(binding.courseDetailLocationFlagBtn)
        }
    }

    private fun setOnClickEvent() {
        dramaAdapter.setItemClickListener(object: CourseDetailDramaAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int) {
                super.onClick(view, position) // 미리 정의해둔 onClick 호출
                dramaAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onExploreSuccess(response: CourseDetailResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    binding.detailCourseTogetherRecyclerview.apply {
                        layoutManager = LinearLayoutManager(context)
                        dramaAdapter = CourseDetailDramaAdapter(it.result?.spotList!!, context)
                        adapter = dramaAdapter
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
