package com.example.fika_project.ui.main.mycourse.course_edit

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.fika_project.databinding.ActivityTestBinding
import com.example.myapplication.MyRecyclerViewAdapter
import com.example.myapplication.SwipeHelperCallback
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class TestActivity : AppCompatActivity() {
    private var _Binding: ActivityTestBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        slidePanelInit()
        initKakaomapData()



    }
    fun initKakaomapData() {
        val mapView = MapView(this)
        val mapViewContainer = findViewById<View>(com.example.fika_project.R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.5518018, 127.0736343),true)
        val marker = MapPOIItem()
        val marker2 = MapPOIItem()
        marker.apply {
            itemName = "우리학교"
            mapPoint = MapPoint.mapPointWithGeoCoord(37.5518018, 127.0736343)
            markerType = MapPOIItem.MarkerType.BluePin
        }
        mapView.addPOIItem(marker)
        marker2.apply {
            itemName = "어디가"
            mapPoint = MapPoint.mapPointWithGeoCoord(37.5518018, 127.973634)
            markerType = MapPOIItem.MarkerType.RedPin
        }
        mapView.addPOIItem(marker2)

    }
    fun slidePanelInit() {
// 리사이클러뷰 아이템 생성
        val items = arrayListOf("안녕 - 조이", "Je T'aime - 조이", "Day by Day - 조이", "좋을텐데(If Only)(Feat. 폴킴) - 조이",
            "Happy Birthday To You - 조이", "그럴때마다(Be There For You) - 조이", "매일 그대와 - 아이유", "너의 의미 - 아이유",
            "여우야 - 조이", "요즘 너 말야 - 조이", "러브레터 - 정승환")

        // 리사이클러뷰 어댑터 달기
        val recyclerViewAdapter = MyRecyclerViewAdapter(items)
        binding.recyclerView.adapter = recyclerViewAdapter

        // 리사이클러뷰에 스와이프, 드래그 기능 달기
        val swipeHelperCallback = SwipeHelperCallback(recyclerViewAdapter).apply {
            // 스와이프한 뒤 고정시킬 위치 지정
            setClamp(resources.displayMetrics.widthPixels.toFloat() / 4)    // 1080 / 4 = 270
        }
        ItemTouchHelper(swipeHelperCallback).attachToRecyclerView(binding.recyclerView)

        // 구분선 추가
        binding.recyclerView.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))

        // 다른 곳 터치 시 기존 선택했던 뷰 닫기
        binding.recyclerView.setOnTouchListener { _, _ ->
            swipeHelperCallback.removePreviousClamp(binding.recyclerView)
            false
        }

    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}