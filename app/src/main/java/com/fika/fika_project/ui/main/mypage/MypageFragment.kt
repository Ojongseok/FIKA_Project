package com.fika.fika_project.ui.main.mypage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentMypageBinding
import com.fika.fika_project.ui.main.mypage.mycourse.MyscrapcourseFragment
import com.fika.fika_project.ui.main.mypage.myspot.MySpotResponse

class MypageFragment : Fragment(), MypageView {
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!
    val service = MypageService(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)

        onClickListener()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service.tryMypage()
        service.tryloadMySpot()
        service.tryMyScrap()
    }


    private fun onClickListener(){
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        binding.mypagePlaceLayout.setOnClickListener{
            fragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.mypage_frm, MyholdcourseFragment())
            }
        }

        binding.mypageCourseLayout.setOnClickListener {
            fragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.mypage_frm, MyscrapcourseFragment())
            }
        }

        binding.mypageEditBtn.setOnClickListener {
            fragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.mypage_frm, EditPersonalFragment())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoading() {
        binding.mypagePb.visibility = View.VISIBLE
    }

    override fun onMypageSuccess(response: MypageResponse) {
        binding.mypagePb.visibility = View.GONE

        when(response.code) {
            1000 -> {
                val resp = response.result!!

                val spot = resp.savedSpotCount.toString()
                val course = resp.savedCourseCount.toString()

                binding.mypageProfileIv.setImageResource(R.drawable.logo_fikaduck)

                binding.mypageProfileTv.setText(resp.memberNickname)
                binding.mypagePlaceNumberTv.text = spot+"つ"
                binding.mypageCourseNumberTv.text = course + "つ"
            }
            else ->{
                binding.mypageProfileTv.setText("FIKA")
            }
        }
    }

    override fun onMySpotSuccess(response: MySpotResponse) {
        when(response.code){
            1000 -> {
                if (response.result!!.size != 0) {
                    Glide.with(requireContext()).load(response.result[0].spotImageUrl)
                        .into(binding.mypagePlaceCoverIv)
                } else {
                    binding.mypagePlaceCoverIv.setImageResource(R.color.white)

                }
            }
        }
    }

    override fun onMyScrapSuccess(response: MyScrapResponse) {
        when(response.code){
            1000 -> {
                if (response.result!!.size != 0) {
                    Glide.with(requireContext()).load(response.result[0].locageImageUrl.toString())
                        .into(binding.mypageCourseCoverIv)

                } else {
                    binding.mypageCourseCoverIv.setImageResource(R.color.white)

                }
            }
        }
    }
}
