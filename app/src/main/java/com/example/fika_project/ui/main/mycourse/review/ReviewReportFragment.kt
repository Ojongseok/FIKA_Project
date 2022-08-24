package com.example.fika_project.ui.main.mycourse.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fika_project.databinding.FragmentReviewReportBinding
import com.example.fika_project.ui.main.MainActivity

class ReviewReportFragment: Fragment() {
    private var _binding: FragmentReviewReportBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentReviewReportBinding.inflate(inflater, container, false)

        initView()
        onClickListener()

        return binding.root
    }

    private fun onClickListener(){
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        binding.reviewReportBackBtn.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
    }

    private fun initView() {
        val mActivity = activity as MainActivity

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}