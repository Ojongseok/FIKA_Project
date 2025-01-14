package com.fika.fika_project.ui.main.mypage.mycourse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.FragmentMyscrapcourseBinding
import com.fika.fika_project.ui.login.LoginActivity
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.ui.main.mypage.*
import com.fika.fika_project.ui.main.mypage.myspot.MySpotResponse


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


    fun setScrapRVAdapter(myScrapList: ArrayList<MyScrap>) {
        val scrapRVAdapter = MyscrapcourseRVAdapter(myScrapList, requireContext())

        binding.myscrapcourseRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.myscrapcourseRv.adapter = scrapRVAdapter
        binding.myscrapcourseRv.setHasFixedSize(false)
    }

    private fun onClickListener() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.myscrapcourseBackIv.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }

        val mActivity = activity as MainActivity
        binding.myscrapcourseHomeIv.setOnClickListener {
            mActivity.changeFragment(1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoading() {
        binding.myscrapcoursePb.visibility = View.VISIBLE
    }

    override fun onMypageSuccess(response: MypageResponse) {
//        없는 함수
    }

    override fun onMySpotSuccess(response: MySpotResponse) {
        //없는 함수
    }

    override fun onMyScrapSuccess(response: MyScrapResponse) {
        binding.myscrapcoursePb.visibility = View.GONE

        when(response.code) {
            1000 -> {
                if(response.result!!.size == 0){
                    binding.myscrapcourseEmptyIv.visibility = View.VISIBLE
                } else {
                    binding.myscrapcourseEmptyIv.visibility = View.GONE
                    response.let { setScrapRVAdapter(it.result!!) }
                }
            }
        }
    }
}