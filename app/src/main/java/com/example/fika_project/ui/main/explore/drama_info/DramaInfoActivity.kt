package com.example.fika_project.ui.main.explore.drama_info

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ActivityDramaInfoBinding
import com.example.fika_project.ui.main.LoadingDialog
import com.example.fika_project.ui.main.explore.DramaInfoResponse
import com.example.fika_project.ui.main.explore.courseList
import com.example.fika_project.ui.main.explore.filter_drama.result
import com.example.fika_project.ui.main.explore.spotDataList
import com.example.fika_project.utils.spfManager
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.io.Serializable

class DramaInfoActivity : AppCompatActivity(), DramaInfoView,Serializable {
    private var _Binding: ActivityDramaInfoBinding? = null
    private val binding get() = _Binding!!
    lateinit var spotlist : ArrayList<spotDataList>
    lateinit var dramaName : String
    var position = 0
    lateinit var loadingDialog : LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityDramaInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadingDialog = LoadingDialog(this)
        initData()



        binding.dramaDetailBackBtn.setOnClickListener { finish() }

        binding.largeMapBtn.setOnClickListener {
            val intent = Intent(this,LargeMapActivity::class.java)
            intent.putExtra("spotlist",spotlist)
            intent.putExtra("position",dramaName)
            startActivity(intent)
        }
    }


    private fun initData() {
        position = intent.getIntExtra("number", 0)

        val service = DramaInfoService(this, position)
        service.tryLoadDramaInfoCourse()
        loadingDialog.show()

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onExploreLoading() {
    }
    override fun onExploreSuccess(response: DramaInfoResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    val resp = response.result

                    Glide.with(this).load(resp.thumbnailUrl).into(binding.dramaInfoMainIv)
                    binding.dramaInfoTitleTv.text =resp.dramaTitle
                    binding.dramaDetailInfoTitleName.text = resp.dramaTitle

                    binding.dramaInfoCourseRecyclerview.layoutManager = LinearLayoutManager(this)
                    binding.dramaInfoCourseRecyclerview.adapter = DramaInfoCourseAdapter(it.result.courseList!!, this)

                    binding.dramaInfoLocationRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
                    binding.dramaInfoLocationRecyclerview.adapter = DramaInfoLocationAdapter(it.result.spotDataList!!, this)
                    spotlist = it.result.spotDataList
                    dramaName = it.result.dramaTitle!!
                }
            }
        }
        loadingDialog.dismiss()
    }

    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }

}