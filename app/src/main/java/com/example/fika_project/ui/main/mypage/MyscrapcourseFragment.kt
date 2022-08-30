package com.example.fika_project.ui.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.FragmentMyscrapcourseBinding
import com.example.fika_project.ui.main.MainActivity
import com.example.fika_project.ui.main.home.*


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

        scrapRVAdapter.setMyItemClickListener(object  : MyscrapcourseRVAdapter.MyItemClickListener{
            override fun onItemClick(mycourse: MyScrap) {
                TODO("Not yet implemented")
            } })
    }

    private fun onClickListener() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.myscrapcourseBackIv.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoading() {
//        TODO("Not yet implemented")
    }

    override fun onMypageSuccess(response: MypageResponse) {
//        없는 함수
    }

    override fun onMyScrapSuccess(response: MyScrapResponse) {
        when(response.code) {
            1000 -> {
                if(response.result!!.size == 0){
                    binding.myscrapcourseEmptyIv.visibility = View.VISIBLE
                } else{
               response?.let { setScrapRVAdapter((it.result!!)) }
            }
            }
        }
    }
}