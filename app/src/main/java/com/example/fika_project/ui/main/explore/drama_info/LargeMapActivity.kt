package com.example.fika_project.ui.main.explore.drama_info

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityLargeMapBinding
import com.example.fika_project.ui.main.explore.spotDataList
import com.kakao.usermgmt.StringSet.name
import kotlinx.android.synthetic.main.activity_large_map.*
import net.daum.mf.map.api.CalloutBalloonAdapter
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapPoint.mapPointWithGeoCoord
import net.daum.mf.map.api.MapView

class LargeMapActivity : AppCompatActivity() {
    private var _Binding: ActivityLargeMapBinding? = null
    private val binding get() = _Binding!!
    lateinit var spotlist : ArrayList<spotDataList>
    val markerList = ArrayList<MapPOIItem>()
    private val eventListener = MarkerEventListener(this,markerList)   // 마커 클릭 이벤트 리스너

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
        val mapViewContainer = findViewById<View>(R.id.large_map) as ViewGroup

        mapView.setCalloutBalloonAdapter(CustomBalloonAdapter(this,layoutInflater))
        mapView.setPOIItemEventListener(eventListener)

        val marker = MapPOIItem()
        for (i in 0 until spotlist.size) {
            marker.apply {
                itemName = spotlist[i].spotTitle
                mapPoint = mapPointWithGeoCoord(spotlist[i].mapY!!, spotlist[i].mapX!!)
                markerType = MapPOIItem.MarkerType.BluePin
                selectedMarkerType = MapPOIItem.MarkerType.RedPin
                isCustomImageAutoscale = true

            }
            mapView.setMapCenterPoint(mapPointWithGeoCoord(spotlist[0].mapY!!, spotlist[0].mapX!!),true)
            mapView.addPOIItem(marker)
            markerList.add(marker)
        }

        mapViewContainer.addView(mapView)

    }
    class CustomBalloonAdapter(val context :Context,inflater: LayoutInflater): CalloutBalloonAdapter {
        val mCalloutBalloon: View = inflater.inflate(R.layout.balloon_layout, null)
        val name: TextView = mCalloutBalloon.findViewById(R.id.textView23)

        override fun getCalloutBalloon(poiItem: MapPOIItem?): View {
            // 마커 클릭 시 나오는 말풍선
            name.text = poiItem?.itemName
            return mCalloutBalloon
        }

        override fun getPressedCalloutBalloon(poiItem: MapPOIItem?): View {
            // 말풍선 클릭 시
            Toast.makeText(context,"12", Toast.LENGTH_SHORT).show()

            return mCalloutBalloon
        }
    }
    class MarkerEventListener(val context: Context,val markerList : ArrayList<MapPOIItem>): MapView.POIItemEventListener {
        override fun onPOIItemSelected(mapView: MapView?, poiItem: MapPOIItem?) {
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
            Toast.makeText(context,"12", Toast.LENGTH_SHORT).show()

        }

        override fun onDraggablePOIItemMoved(p0: MapView?, p1: MapPOIItem?, p2: MapPoint?) {
            // 마커의 속성 중 isDraggable = true 일 때 마커를 이동시켰을 경우
        }
    }
}