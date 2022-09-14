package com.fika.fika_project.ui.main.mycourse.course_edit.add_location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.ActivityMyHoldLocationBinding
import com.fika.fika_project.ui.main.explore.AddLocationResponse
import com.fika.fika_project.ui.main.mypage.myspot.MySpotResponse
import com.fika.fika_project.ui.main.mypage.myspot.MySpotService
import com.fika.fika_project.ui.main.mypage.myspot.MySpotView

class MyHoldLocationActivity : AppCompatActivity(),AddLocationView,MySpotView {
    private var _Binding: ActivityMyHoldLocationBinding? = null
    private val binding get() = _Binding!!
    var courseId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityMyHoldLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.myholdBackBtn.setOnClickListener { finish() }
//        courseId = intent.getIntExtra("courseId",0)
//        val service = AddLocationService(this,courseId)
//        service.tryAddLocation()
        val service = MySpotService(this)
        service.tryloadMySpot()
    }

    override fun onExploreLoading() {
        binding.holdLocationPr.visibility = View.VISIBLE
    }

    override fun onExploreSuccess(response: MySpotResponse) {
        when(response.code) {
            1000 -> {
                binding.holdLocationPr.visibility = View.GONE
                response.let {
                    binding.myholdLocationRecyclerview.adapter = MyHoldLocationAdapter(this, it.result!!)
                    binding.myholdLocationRecyclerview.layoutManager = LinearLayoutManager(this)

                }
            }
        }
    }

    override fun onExploreSuccess(response: AddLocationResponse) {

    }

    override fun onExploreFailure(code: Int, message: String) {
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}