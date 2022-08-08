package com.example.fika_project.ui.main

import android.R
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.fika_project.databinding.ActivityTestBinding
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
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}