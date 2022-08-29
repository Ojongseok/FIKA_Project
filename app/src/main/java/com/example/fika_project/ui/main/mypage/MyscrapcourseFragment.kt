package com.example.fika_project.ui.main.mypage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.ApplicationClass
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentMyscrapcourseBinding
import com.example.fika_project.ui.main.home.HomeService
import com.example.fika_project.ui.main.home.HomeView
import com.example.fika_project.ui.main.home.PlaceRankRVAdapter
import com.example.fika_project.ui.main.home.spotsSortBySaved
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.fika_project.retrofit.RetrofitInterface as RetrofitInterface

class MyscrapcourseFragment: Fragment(), MypageView {
    private var _binding: FragmentMyscrapcourseBinding? = null
    private val binding get() = _binding!!

    val service = MypageService(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyscrapcourseBinding.inflate(inflater, container, false)

        onClickListener()
        service.tryMyScrap()
        return binding.root
    }

        private fun onClickListener() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.myscrapcourseBackIv.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
    }

    fun setScrapRVAdapter(myScrapList: ArrayList<MyScrap>) {
        val scrapRVAdapter = MyscrapcourseRVAdapter(myScrapList, requireContext())

        binding.myscrapcourseRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.myscrapcourseRv.adapter = scrapRVAdapter
        binding.myscrapcourseRv.setHasFixedSize(false)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoading() {
//        TODO("Not yet implemented")
    }

    override fun onMypageSuccess(response: MypageResponse) {
//        d없는 함수
    }

    override fun onMyScrapSuccess(response: MyScrapResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    response?.let { setScrapRVAdapter((it.result!!)) }
                }
            }
        }    }
}
//
//private fun tryMyScrap(){
//    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
//    retrofit.MyScrap().enqueue(object : Callback<MyScrapResponse> {
//        override fun onResponse(call: Call<MyScrapResponse>, response: Response<MyScrapResponse>) {
//            var result: MyScrapResponse? = response.body()
//            val resp = response.body()!!
//
//            Log.d("IDCHECK/API-RESPONSE", result.toString())
//
//            when(resp.code){
//                1000 -> { //성공
//                    resp?.let { setScrapRVAdapter(it.result!!) }
//
//                }
//            }}
//
//        override fun onFailure(call: Call<MyScrapResponse>, t: Throwable) {
//            Log.d("IDCHECK/API-ERROR", t.toString())
//        }
//    })}
