package com.example.fika_project.ui.main.explore.drama_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ActivityDramaInfoBinding
import com.example.fika_project.ui.main.explore.DramaInfoResponse
import com.example.fika_project.ui.main.explore.filter_drama.result
import net.daum.mf.map.api.MapView

class DramaInfoActivity : AppCompatActivity(), DramaInfoView {
    private var _Binding: ActivityDramaInfoBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityDramaInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()


        val mapView = MapView(this)
        val mapViewContainer = findViewById<View>(com.example.fika_project.R.id.drama_info_mapview) as ViewGroup
        mapViewContainer.addView(mapView)

    }

    private fun initData() {
        val dramalist : ArrayList<result> = intent.getSerializableExtra("dramalist") as ArrayList<result>
        val position = intent.getIntExtra("number", 0)

        val service = DramaInfoService(this,dramalist[position].dramaId!!)
        service.tryLoadDramaInfoCourse()

        Glide.with(this).load(dramalist[position].thumbnailUrl).into(binding.dramaInfoMainIv)
        binding.dramaInfoTitleTv.text = dramalist[position].dramaTitle
    }

    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }

    override fun onExploreLoading() {
    }

    override fun onExploreSuccess(response: DramaInfoResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    binding.dramaInfoCourseRecyclerview.layoutManager = LinearLayoutManager(this)
                    binding.dramaInfoCourseRecyclerview.adapter = DramaInfoCourseAdapter(it.result.courseList!!, this)

                    binding.dramaInfoLocationRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                    binding.dramaInfoLocationRecyclerview.adapter = DramaInfoLocationAdapter(it.result.spotDataList!!, this)
                }
            }
        }
    }

    override fun onExploreFailure(code: Int, message: String) {
    }
}