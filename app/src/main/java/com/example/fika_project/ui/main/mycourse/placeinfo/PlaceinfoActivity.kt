package com.example.fika_project.ui.main.mycourse.placeinfo

import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.fika_project.databinding.ActivityPlaceinfoLocateBinding

class PlaceinfoActivity: AppCompatActivity(), PlaceinfoView {
    lateinit var binding: ActivityPlaceinfoLocateBinding
    val service = PlaceinfoService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceinfoLocateBinding.inflate(layoutInflater)
        initView()

        setContentView(binding.root)
    }

    private fun initView() {
        binding.placeinfoLocateUpBtn.setOnClickListener {
                binding.placeinfoLocateSv.fullScroll(ScrollView.FOCUS_UP)
        }

        binding.placeinfoLocateAllReviewBtn.setOnClickListener {

        }
    }

    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onPlaceinfoSuccess(response: PlaceInfoResponse) {
        when(response?.code){
            //성공
            1000 -> {
                val resp = response.result!![0]
                Glide.with(this).load(resp.spotImageUrl).into(binding.placeinfoLocateCoverIv)
                binding.placeinfoHashtagTv.text = resp.hashTag
                Glide.with(this).load(resp.dialogImageUrl).into(binding.placeinfoDialogIv)


                Log.d("PLACEINFO/1000", response.message)
            }

            4020 -> { Log.d("PLACEINFO/4020", "필수값이 포함되지 않은 경우") }
            4026 -> { Log.d("PLACEINFO/4026", "spotId가 숫자가 아닌경우") }
            else ->  {
                Log.d("PLACEINFO", "실패 : 오류")
            } }    }
}