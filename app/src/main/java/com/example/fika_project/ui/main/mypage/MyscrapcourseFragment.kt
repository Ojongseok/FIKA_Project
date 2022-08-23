package com.example.fika_project.ui.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentMyscrapcourseBinding
import com.example.fika_project.ui.main.home.Course
import com.example.fika_project.ui.main.home.DramaRank
import com.example.fika_project.ui.main.home.PlaceRank
import com.example.fika_project.ui.main.home.ScrapCourserank
import com.example.fika_project.ui.main.mycourse.review.AllReviewRVAdapter
import com.example.fika_project.ui.main.mycourse.review.Review

class MyscrapcourseFragment: Fragment() {
    private var _binding: FragmentMyscrapcourseBinding? = null
    private val binding get() = _binding!!

    private var myScrapcourseDatas = ArrayList<Myscrapcourse>();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyscrapcourseBinding.inflate(inflater, container, false)

        onClickListener()
        initView()
        initData()

        return binding.root
    }

    private fun initView() {
        binding.myscrapcourseRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val myscrapcourseRVAdapter = MyscrapcourseRVAdapter(myScrapcourseDatas)
        binding.myscrapcourseRv.adapter = myscrapcourseRVAdapter
    }

    private fun initData(){
        myScrapcourseDatas.apply {
            add(Myscrapcourse(1, R.color.sub_blue, "우영우 코스","이상한 변호사 우영우"))
            add(Myscrapcourse(2, R.color.sub_yellow, "박새로이 코스","이태원클라스"))
            add(Myscrapcourse(3, R.color.main_blue, "우영우 코스","이상한 변호사 우영우"))
            add(Myscrapcourse(4, R.color.main_yellow, "박새로이 코스","이태원클라스"))
        }

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
}