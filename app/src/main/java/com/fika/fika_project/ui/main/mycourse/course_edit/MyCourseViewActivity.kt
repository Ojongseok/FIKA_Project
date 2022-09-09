package com.fika.fika_project.ui.main.mycourse.course_edit

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityMycourseViewBinding
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
        Log.d("TAG",courseId.toString())
        val service = CourseViewService(this,courseId)
        service.tryCourseView()

        binding.myholdBackBtn.setOnClickListener { finish() }
        supportFragmentManager.beginTransaction().replace(R.id.mycourse_view_list_container,MyCourseSaveState()
            .apply {
                val bundle = Bundle()
                bundle.putInt("courseId",courseId)
                arguments = bundle
            }).commit()
        binding.myholdHomeBtn.setOnClickListener {
//            val intent = Intent(this,MainActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
//            startActivity(intent)
//            finish()
        }

        binding.mycourseViewAddLocation.setOnClickListener {
            startActivity(Intent(this, MyHoldLocationActivity::class.java))
        }
    }
    fun initKakaomapData(spotList: ArrayList<spotList>) {
        val mapView = MapView(this)
        val mapViewContainer = findViewById<View>(R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(spotList[0].mapY!!, spotList[0].mapX!!),true)

        for (i in 0 until spotList.size) {
            val marker = MapPOIItem()
            marker.apply {
                itemName = spotList[i].spotTitle
                mapPoint = MapPoint.mapPointWithGeoCoord(spotList[i].mapY!!, spotList[i].mapX!!)
                markerType = MapPOIItem.MarkerType.CustomImage
                if (spotList[i].type.equals("cafe")) {
                    customImageResourceId = R.drawable.marker_yellow
                } else if (spotList[i].type.equals("playground")) {
                    customImageResourceId = R.drawable.marker_blue
                } else {
                    customImageResourceId = R.drawable.marker_red
                }
                setCustomImageAnchor(1.0f,1.0f)
                isCustomImageAutoscale = false
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