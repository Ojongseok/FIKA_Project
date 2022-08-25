package com.example.fika_project.ui.main.mycourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.example.fika_project.databinding.FragmentPlaceinfoBinding
import com.example.fika_project.ui.main.MainActivity

class PlaceinfoFragment: Fragment() {
    private var _binding: FragmentPlaceinfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPlaceinfoBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    private fun initView() {
        val mActivity = activity as MainActivity

        binding.placeinfoUpBtn.setOnClickListener {
            binding.placeinfoSv.fullScroll(ScrollView.FOCUS_UP)
        }

        binding.placeinfoAllReviewBtn.setOnClickListener {
            mActivity.changeFragment(2)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}