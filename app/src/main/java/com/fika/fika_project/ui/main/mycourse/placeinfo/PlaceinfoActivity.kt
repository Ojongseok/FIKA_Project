package com.fika.fika_project.ui.main.mycourse.placeinfo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityPlaceinfoLocateBinding
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapService
import com.fika.fika_project.ui.main.mycourse.review.AllReviewFragment
import com.fika.fika_project.ui.main.mycourse.review.ReviewReportFragment
import com.fika.fika_project.ui.main.mypage.MyScrap
import com.fika.fika_project.ui.main.mypage.mycourse.MyscrapcourseRVAdapter
import com.fika.fika_project.ui.main.mypage.myspot.MyspotRVAdapter
import com.fika.fika_project.utils.spfManager
import io.reactivex.Single
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import timber.log.Timber

class PlaceinfoActivity: AppCompatActivity(), PlaceinfoView {
    lateinit var binding: ActivityPlaceinfoLocateBinding
    val service = PlaceinfoService(this)
    var money = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlaceinfoLocateBinding.inflate(layoutInflater)
        initView()

        setContentView(binding.root)
    }
    private fun initView() {
        val homeSpotId = intent.getIntExtra("homeSpotId",0)
        Timber.tag("Print_CourseId").d(homeSpotId.toString())

        spfManager.setCourseId(homeSpotId)

        service.tryPlaceinfo(homeSpotId!!)

        binding.placeinfoLocateBackIv.setOnClickListener {
            finish()
        }

        binding.placeinfoLocateHomeIv.setOnClickListener {
            finish()
        }

        binding.placeinfoLocateUpBtn.setOnClickListener {
                binding.placeinfoLocateSv.fullScroll(ScrollView.FOCUS_UP)
        }

        binding.placeinfoLocateAllReviewBtn.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeinfo_locate_frm, AllReviewFragment())
                .commitAllowingStateLoss() }

        binding.itemPlaceinfoReviewMoreIv.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.placeinfo_locate_frm, ReviewReportFragment())
                .commitAllowingStateLoss() }
        }

    fun setMenuRVAdapter(menuList: ArrayList<MenuList>) {
        Thread(Runnable {
            val url ="https://search.naver.com/search.naver?where=nexearch&sm=top_sug.ase&fbm=0&acr=1&acq=%EC%97%94%ED%99%94+&qdt=0&ie=utf8&query=%EC%97%94%ED%99%94+%ED%99%98%EC%9C%A8"
            val doc = Jsoup.connect(url).get()
            money = doc.select("span.spt_con strong").text()
            Log.d("menu",money)

            this@PlaceinfoActivity.runOnUiThread(java.lang.Runnable {
                val scrapRVAdapter = MenulistRVAdapter(menuList, this,money)

                binding.placeinfoLocateMenuRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.placeinfoLocateMenuRv.adapter = scrapRVAdapter
                binding.placeinfoLocateMenuRv.setHasFixedSize(false)
            })
        }).start()


    }

    override fun onLoading() {
        binding.placeinfoPb.visibility = View.VISIBLE
    }

    override fun onPlaceinfoSuccess(response: PlaceInfoResponse) {
        binding.placeinfoPb.visibility = View.GONE

        when(response?.code){
            //성공
            1000 -> {
                val resp = response.result!!

                if(resp.locage == true){
                    binding.placeinfoLocateTagIv.visibility = View.VISIBLE
                    Glide.with(this).load(resp.dialogImageUrl).into(binding.placeinfoDialogIv)
                    binding.placeinfoHashtagTv.text = resp.hashTag
                }else{
                    binding.placeinfoLocateTagIv.visibility = View.GONE
                    binding.placeinfoDialogIv.visibility = View.GONE
                    binding.placeinfoHashtagTv.visibility = View.GONE
                }


                Glide.with(this).load(resp.spotImageUrl).into(binding.placeinfoLocateCoverIv)
                binding.placeinfoLocateCoverTv.text = resp.spotTitle
                binding.placeinfoLocateTimeTv.text = resp.timeOpened
                binding.placeinfoLocateCoverAddressTv.text = resp.address
                binding.placeinfoLocateWhereInfoTv.text = resp.address
                binding.placeinfoLocateCallTv.text = resp.phoneNumber

                //메뉴
                if(resp.spotMenuList?.size == 0){
                    binding.placeinfoLocateMenuLayout.visibility = View.GONE
                }else{
                    binding.placeinfoLocateMenuLayout.visibility = View.VISIBLE
                    binding.placeinfoLocateMenuRv.visibility = View.VISIBLE
                    response.let { setMenuRVAdapter(it.result!!.spotMenuList!!) }
                }

                //리뷰
                if(resp.reviewList?.size == 0){
                    binding.itemPlaceinfoReviewTopLayout.visibility = View.GONE
                    binding.itemPlaceinfoReviewBottomLayout.visibility = View.GONE
                    binding.itemPlaceinfoReviewBottomImgLayout.visibility = View.GONE
                }else{
                    binding.itemPlaceinfoReviewScoreTv.text = "( ${resp.reviewCount} )"
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