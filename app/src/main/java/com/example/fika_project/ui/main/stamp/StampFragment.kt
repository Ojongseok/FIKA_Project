package com.example.fika_project.ui.main.stamp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fika_project.databinding.FragmentStampBinding
import com.example.fika_project.ui.main.tour.course_edit.TestActivity

class StampFragment:Fragment() {
    private var _binding: FragmentStampBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStampBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            startActivity(Intent(requireContext(), TestActivity::class.java))
        }
        binding.testButton1.setOnClickListener {
            val url = "kakaomap://route?sp=37.5518018, 127.0736343&ep=37.5518018, 127.973634&by=CAR"
            var intent =  Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            var list = activity?.packageManager?.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)

            startActivity(intent)

            // 설치 되어있으면 카맵으로 넘어가야되는데 안됨
//            if (list== null || list.isEmpty()){
//                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=net.daum.android.map")))
//            }else{
//                startActivity(intent)
//            }
        }



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}