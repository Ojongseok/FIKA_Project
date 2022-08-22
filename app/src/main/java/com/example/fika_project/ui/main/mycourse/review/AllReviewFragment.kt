package com.example.fika_project.ui.main.mycourse.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentAllReviewBinding
import com.example.fika_project.ui.main.MainActivity
import com.google.gson.Gson

class AllReviewFragment: Fragment() {
    private var _binding: FragmentAllReviewBinding? = null
    private val binding get() = _binding!!

    private var reviewDatas = ArrayList<Review>();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAllReviewBinding.inflate(inflater, container, false)

        initView()
        initData()

        return binding.root
    }

    private fun initView() {
        binding.allReviewRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val allReviewRVAdapter = AllReviewRVAdapter(reviewDatas)
        binding.allReviewRv.adapter = allReviewRVAdapter

        allReviewRVAdapter.setMyItemClickListener(object : AllReviewRVAdapter.MyItemClickListener{
            override fun onItemClick(review: Review) {
                viewReviewImgFrag(review)
            }

        })
    }

    private fun initData() {
        reviewDatas.apply {
            add(Review(1, "새로이짱", R.drawable.ic_star_on, "2011-1-11", R.color.main_blue,"아아아아 좋다~~"))
            add(Review(1, "다람쥐", R.drawable.ic_star_off, "2011-1-11", R.color.black,"아아아아 좋다~~아아아아 좋다~~"))
            add(Review(1, "가나다", R.drawable.ic_star_on, "2011-1-11", R.color.sub_yellow,"아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~"))
            add(Review(1, "조이서짱", R.drawable.ic_star_off, "2011-1-11", R.color.purple_500,"아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~아아아아 좋다~~"))
        }
    }

    private fun viewReviewImgFrag(review: Review) {
            (context as MainActivity).supportFragmentManager.beginTransaction()
            .add(R.id.placeinfo_locate_frm, ReviewImgFragment().apply {
                arguments = Bundle().apply {
                    val gson = Gson()
                    val reviewJson = gson.toJson(review)
                    putString("review", reviewJson)
                }
            })
            .commitAllowingStateLoss()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}