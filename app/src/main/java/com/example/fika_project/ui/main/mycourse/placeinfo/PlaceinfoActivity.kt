package com.example.fika_project.ui.main.mycourse.placeinfo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityPlaceinfoLocateBinding
import com.example.fika_project.ui.main.explore.drama_info.DramaInfoService
import com.example.fika_project.ui.main.mycourse.review.AllReviewFragment
import com.example.fika_project.ui.main.mycourse.review.ReviewReportFragment
import com.example.fika_project.ui.main.mypage.MypageFragment
import com.example.fika_project.utils.spfManager
import com.google.gson.Gson

class PlaceinfoActivity: AppCompatActivity(), PlaceinfoView {
    lateinit var binding: ActivityPlaceinfoLocateBinding
    val courseId = spfManager.getCourseId()!!.toInt()
    val service = PlaceinfoService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceinfoLocateBinding.inflate(layoutInflater)
        initView()

        service.tryPlaceinfo(courseId)
        setContentView(binding.root)
    }

    private fun initView() {
        binding.placeinfoLocateUpBtn.setOnClickListener {
                binding.placeinfoLocateSv.fullScroll(ScrollView.FOCUS_UP)
        }

        binding.placeinfoLocateAllReviewBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeinfo_locate_frm, AllReviewFragment())
                .commitAllowingStateLoss() }

        binding.placeinfoLocateMoreIv.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeinfo_locate_frm, ReviewReportFragment())
                .commitAllowingStateLoss() }
        }

    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onPlaceinfoSuccess(response: PlaceInfoResponse) {
        when(response?.code){
            //성공
            1000 -> {
                val resp = response.result!!

                if(resp.locage == true){
                    binding.placeinfoLocateTagIv.visibility = View.VISIBLE
                    Glide.with(this).load(resp.dialogImageUrl).into(binding.placeinfoDialogIv)
                }else{
                    binding.placeinfoLocateTagIv.visibility = View.GONE
                    binding.placeinfoDialogIv.visibility = View.GONE
                }

                binding.placeinfoHashtagTv.text = resp.hashTag
                Glide.with(this).load(resp.spotImageUrl).into(binding.placeinfoLocateCoverIv)
                binding.placeinfoLocateCoverTv.text = resp.spotTitle
                binding.placeinfoLocateCoverAddressTv.text = resp.address
                binding.placeinfoLocateWhereInfoTv.text = resp.address
                binding.placeinfoLocateCallTv.text = resp.phoneNumber

                //메뉴
                if(resp.spotMenuList?.size == 0){
                    binding.placeinfoLocateMenuTv1.visibility = View.GONE
                    binding.placeinfoLocateMenuPriceTv1.visibility = View.GONE
                    binding.placeinfoLocateMenuTv2.visibility = View.GONE
                    binding.placeinfoLocateMenuPriceTv2.visibility = View.GONE
                }else{
                    binding.placeinfoLocateMenuTv1.text = resp.spotMenuList!![0].menuName
                    binding.placeinfoLocateMenuPriceTv1.text = resp.spotMenuList!![0].menuPrice
                    binding.placeinfoLocateMenuTv2.text = resp.spotMenuList!![1].menuName
                    binding.placeinfoLocateMenuPriceTv2.text = resp.spotMenuList!![1].menuPrice
                }

                //리뷰
                if(resp.reviewList?.size == 0){
                    binding.itemPlaceinfoReviewTopLayout.visibility = View.GONE
                    binding.itemPlaceinfoReviewBottomLayout.visibility = View.GONE
                    binding.itemPlaceinfoReviewBottomImgLayout.visibility = View.GONE
                }else{
                    binding.itemPlaceinfoReviewNameTv.text = resp.reviewList!![0].userNickname
                    binding.itemPlaceinfoReviewContentsTv.text = resp.reviewList!![0].reviewContents
                    Glide.with(this).load(resp.reviewList!![0].imageUrls!![0]).into(binding.itemPlaceinfoReviewImg01)
                    Glide.with(this).load(resp.reviewList!![0].imageUrls!![1]).into(binding.itemPlaceinfoReviewImg02)
                    Glide.with(this).load(resp.reviewList!![0].imageUrls!![2]).into(binding.itemPlaceinfoReviewImg03)
                    binding.itemPlaceinfoReviewDateTv.text = resp.reviewList!![0].createAt
                }

                Log.d("PLACEINFO/1000", response.message)
            }

            4020 -> { Log.d("PLACEINFO/4020", "필수값이 포함되지 않은 경우") }
            4026 -> { Log.d("PLACEINFO/4026", "spotId가 숫자가 아닌경우") }
            else ->  {
                Log.d("PLACEINFO", "실패 : 오류")
            }
        }
    }

    override fun onReviewReportSuccess(response: ReportResponse) {
        //없는 함수
    }
}