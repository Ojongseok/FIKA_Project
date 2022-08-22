package com.example.fika_project.ui.main.mycourse.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.fika_project.databinding.FragmentReviewImgBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson

class ReviewImgFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentReviewImgBinding? = null
    private val binding get() = _binding!!
    val gson : Gson = Gson()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentReviewImgBinding.inflate(inflater, container, false)

        val reviewData = arguments?.getString("review")
        val review = gson.fromJson(reviewData, Review::class.java)

        setView(review)
        onClickListener()

        return binding.root
    }

    private fun setView(review: Review) {
        val reviewImg = review.reviewImg
        binding.dialogReviewIv.setImageResource(reviewImg!!)

    }

    private fun onClickListener(){
        binding.dialogReviewCloseIv.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }

        binding.dialogReviewLayout.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}