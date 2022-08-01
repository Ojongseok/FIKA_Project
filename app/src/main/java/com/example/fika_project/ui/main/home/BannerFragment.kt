package com.example.fika_project.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentBannerBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class BannerFragment(val img : Int, title:String) : Fragment(){
    lateinit var binding: FragmentBannerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(inflater, container, false)

        binding.bannerImageIv.setImageResource(img)
        binding.bannerTitleTv.setText("미리보기")

        return binding.root
    }
}