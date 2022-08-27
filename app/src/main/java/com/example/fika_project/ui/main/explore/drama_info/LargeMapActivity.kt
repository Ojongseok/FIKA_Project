package com.example.fika_project.ui.main.explore.drama_info

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityLargeMapBinding
import com.example.fika_project.ui.main.explore.filter_drama.result
import com.example.fika_project.ui.main.explore.spotDataList
import kotlinx.android.synthetic.main.activity_large_map.*
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapPoint.mapPointWithGeoCoord
import net.daum.mf.map.api.MapView

class LargeMapActivity : AppCompatActivity() {
    private var _Binding: ActivityLargeMapBinding? = null
    private val binding get() = _Binding!!
    lateinit var spotlist : ArrayList<spotDataList>
    val markerList = ArrayList<MapPOIItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityLargeMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
    }

    private fun initData() {
        spotlist = intent.getSerializableExtra("spotlist") as ArrayList<spotDataList>
        val position = intent.getStringExtra("position")

        binding.largeMapTitleName.text = position
        binding.myholdBackBtn.setOnClickListener {
            finish()
        }

        val mapView = MapView(this)
        val mapViewContainer = findViewById<View>(com.example.fika_project.R.id.large_map) as ViewGroup
        mapViewContainer.addView(mapView)
        val marker = MapPOIItem()
        for (i in 0 until spotlist.size) {
            marker.apply {
                itemName = spotlist[i].spotTitle
                mapPoint = mapPointWithGeoCoord(spotlist[i].mapY!!, spotlist[i].mapX!!)
                markerType = MapPOIItem.MarkerType.BluePin
                selectedMarkerType = MapPOIItem.MarkerType.RedPin
                isCustomImageAutoscale = true

            }
 //           mapView.setMapCenterPoint(mapPointWithGeoCoord(spotlist[i].mapY!!, spotlist[i].mapX!!),true)
            mapView.addPOIItem(marker)
            markerList.add(marker)
        }
        mapView.setPOIItemEventListener(MarkerEventListener(this,markerList))
    }
    class MarkerEventListener(val context: Context,val markerList : ArrayList<MapPOIItem>): MapView.POIItemEventListener {
        override fun onPOIItemSelected(mapView: MapView?, poiItem: MapPOIItem?) {
            Log.d("TTT","asd123")
            for (i in 0 until markerList.size) {
                if (markerList.contains(poiItem)) {
                    Log.d("TTT",i.toString())
                }
            }
        }

        override fun onCalloutBalloonOfPOIItemTouched(mapView: MapView?, poiItem: MapPOIItem?) {
            // 말풍선 클릭 시 (Deprecated)
            // 이 함수도 작동하지만 그냥 아래 있는 함수에 작성하자
        }

        override fun onCalloutBalloonOfPOIItemTouched(
            mapView: MapView?,
            poiItem: MapPOIItem?,
            buttonType: MapPOIItem.CalloutBalloonButtonType?
        ) {
            // 말풍선 클릭 시
            Log.d("TTT","123".toString())
        }

        override fun onDraggablePOIItemMoved(p0: MapView?, p1: MapPOIItem?, p2: MapPoint?) {
            // 마커의 속성 중 isDraggable = true 일 때 마커를 이동시켰을 경우
        }
    }
}