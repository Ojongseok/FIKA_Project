package com.fika.fika_project.ui.main.mycourse.course_edit

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityMycourseViewBinding
import com.fika.fika_project.ui.main.mycourse.course_edit.state_edit.MyCourseEditState
import com.fika.fika_project.ui.main.mycourse.course_edit.state_save.*
import com.sothree.slidinguppanel.SlidingUpPanelLayout
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class MyCourseViewActivity :AppCompatActivity(),CourseViewView {
    private var _Binding: ActivityMycourseViewBinding? = null
    private val binding get() = _Binding!!
    var editState : Boolean = false
    var courseId = 0
    lateinit var spotList : ArrayList<spotList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityMycourseViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val slidePanel = binding.mainFrame
        slidePanel.addPanelSlideListener(PanelEventListener())

        courseId = intent.getIntExtra("courseId",0)
        val service = CourseViewService(this,courseId)
        service.tryCourseView()

        binding.myholdBackBtn.setOnClickListener { finish() }
        supportFragmentManager.beginTransaction().replace(R.id.mycourse_view_list_container,MyCourseSaveState()
            .apply {
                val bundle = Bundle()
                bundle.putInt("courseId",courseId)
                arguments = bundle
            }).commit()

//        binding.mycourseEditBtn.setOnClickListener {
//            if (editState) {
//                binding.mycourseEditBtn.text = "편집"
//                editState = false
//                binding.mycourseEditText.visibility = View.INVISIBLE
//                binding.myholdTitle.visibility = View.VISIBLE
//                supportFragmentManager.beginTransaction().replace(R.id.mycourse_view_list_container,MyCourseSaveState()).commit()
//            } else {
//                binding.mycourseEditBtn.text = "저장"
//                editState = true
//                binding.mycourseEditText.visibility = View.VISIBLE
//                binding.myholdTitle.visibility = View.INVISIBLE
//                supportFragmentManager.beginTransaction().replace(R.id.mycourse_view_list_container,
//                    MyCourseEditState()
//                ).commit()
//            }
//        }
        binding.mycourseViewAddLocation.setOnClickListener {
            startActivity(Intent(this, MyHoldLocationActivity::class.java))
        }
    }
    fun initKakaomapData(spotList: ArrayList<spotList>) {
        val mapView = MapView(this)
        val mapViewContainer = findViewById<View>(R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.5518018, 127.0736343),true)

        for (i in 0 until spotList.size) {
            val marker = MapPOIItem()
            marker.apply {
                itemName = spotList[i].spotTitle
                mapPoint = MapPoint.mapPointWithGeoCoord(spotList[i].mapY!!, spotList[i].mapX!!)
                markerType = MapPOIItem.MarkerType.BluePin
            }
            mapView.addPOIItem(marker)
        }
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }

    override fun onExploreSuccess(response: CourseViewResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    spotList = it.result?.spotList!!
                    initKakaomapData(spotList)
                }
            }
        }
    }
    inner class PanelEventListener : SlidingUpPanelLayout.PanelSlideListener {
        // 패널이 슬라이드 중일 때
        override fun onPanelSlide(panel: View?, slideOffset: Float) {
        }
        // 패널의 상태가 변했을 때
        override fun onPanelStateChanged(panel: View?, previousState: SlidingUpPanelLayout.PanelState?, newState: SlidingUpPanelLayout.PanelState?) {
            if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
                panel?.isEnabled = false
                binding.mycourseIndicatorBar.setOnTouchListener { view, motionEvent ->
                    if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                        panel?.isEnabled = true
                    }
                    true
                }
            }
        }
    }
    override fun onExploreFailure() {
    }
}