package com.example.fika_project.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_banner.*

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var rankDatas = ArrayList<Rank>();
    private var courseDatas = ArrayList<Course>();


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initView()
        initData()

        return binding.root
    }

    private fun initView() {
        val bannerAdapter = BannerVPAdapter(this)
        binding.homeBannerVp.adapter = bannerAdapter
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        bannerAdapter.addFragment(BannerFragment(R.color.sub_blue,"추천코스"))
        bannerAdapter.addFragment(BannerFragment(R.color.main_yellow,"인기코스코스"))

        binding.homeCourseMakingRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val courseRVAdaper = CourseMakingRVAdapter(courseDatas)
        binding.homeCourseMakingRv.adapter = courseRVAdaper

        binding.homeRankRv.layoutManager =
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val rankRVAdapter = RankRVAdapter(rankDatas)
        binding.homeRankRv.adapter = rankRVAdapter
    }



    private fun initData(){
        courseDatas.apply {
            add(Course(1, R.color.sub_blue, "우영우 코스","이상한 변호사 우영우","법원"))
            add(Course(2, R.color.sub_yellow, "박새로이 코스","이태원클라스","단밤포차"))
            add(Course(3, R.color.main_blue, "우영우 코스","이상한 변호사 우영우","법원"))
            add(Course(4, R.color.main_yellow, "박새로이 코스","이태원클라스","단밤포차"))
        }

        rankDatas.apply {
            add(Rank(1, R.color.sub_blue, "우영우","1. 우영우의 등장!"))
            add(Rank(2, R.color.main_blue, "우영우우우","1. 팽나무의 전설"))
            add(Rank(3, R.color.sub_yellow, "우영우우우","1. 방구뽕씨!"))
            add(Rank(4, R.color.main_yellow, "우영우우우","1. 동 투더 그 투더 라미"))
            add(Rank(5, R.color.sub_blue, "우영우우우","1. 동동일 동동이 동동삼"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}