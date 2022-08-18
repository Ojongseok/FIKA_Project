package com.example.fika_project.ui.main.explore

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fika_project.databinding.FragmentExploreBinding
import com.example.fika_project.databinding.FragmentKakaomapTestBinding
import com.example.fika_project.ui.main.mycourse.MyCourseFragment
import com.example.fika_project.ui.main.mycourse.course_edit.MyCourseViewActivity

class KakaomapTestFragment:Fragment() {
    private var _binding: FragmentKakaomapTestBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentKakaomapTestBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            startActivity(Intent(requireContext(), MyCourseViewActivity::class.java))
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