package com.example.fika_project.ui.main.explore.drama_info

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ActivityDramaInfoBinding
import com.example.fika_project.ui.main.explore.DramaInfoResponse
import com.example.fika_project.ui.main.explore.courseList
import com.example.fika_project.ui.main.explore.filter_drama.result
import com.example.fika_project.ui.main.explore.spotDataList
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.io.Serializable

class DramaInfoActivity : AppCompatActivity(), DramaInfoView,Serializable {
    private var _Binding: ActivityDramaInfoBinding? = null
    private val binding get() = _Binding!!
    lateinit var dramalist : ArrayList<result>
    var position = 0
    lateinit var spotlist : ArrayList<spotDataList>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityDramaInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()

        binding.dramaDetailBackBtn.setOnClickListener { finish() }
        binding.largeMapBtn.setOnClickListener {
            val intent = Intent(this,LargeMapActivity::class.java)
            intent.putExtra("spotlist",spotlist)
            intent.putExtra("position",dramalist[position].dramaTitle)
            startActivity(intent)
        }

    }

    private fun initData() {
        dramalist = intent.getSerializableExtra("dramalist") as ArrayList<result>
        position = intent.getIntExtra("number", 0)

        val service = DramaInfoService(this, dramalist[position].dramaId!!)
        service.tryLoadDramaInfoCourse()

        Glide.with(this).load(dramalist[position].thumbnailUrl).into(binding.dramaInfoMainIv)
        binding.dramaInfoTitleTv.text = dramalist[position].dramaTitle
        binding.dramaDetailInfoTitleName.text = dramalist[position].dramaTitle

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
                    spotlist = it.result.spotDataList
                }
            }
        }
    }
    override fun onExploreFailure(code: Int, message: String) {
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }

}