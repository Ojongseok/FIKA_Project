package com.example.fika_project.ui.main.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentMypageBinding
import com.example.fika_project.ui.main.explore.course_detail.result
import com.example.fika_project.ui.main.explore.drama_info.DramaInfoCourseAdapter
import com.example.fika_project.ui.main.explore.drama_info.DramaInfoLocationAdapter
import com.example.fika_project.ui.main.explore.filter_drama.ExploreService
import com.example.fika_project.ui.main.mypage.myspot.MySpotActivity
import com.example.fika_project.ui.main.mypage.myspot.MySpotResponse
import com.example.fika_project.ui.main.mypage.myspot.MySpotService
import com.example.fika_project.ui.main.mypage.myspot.MySpotView
import com.example.fika_project.utils.spfManager

class MypageFragment : Fragment(),MypageView {
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!
    val service = MypageService(this)

    lateinit var mySpotList : ArrayList<com.example.fika_project.ui.main.mypage.myspot.result>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)

        onClickListener()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service.tryMypage()
//        binding.mypageProfileTv.setText(spfManager.getNickname().toString())
    }


    private fun onClickListener(){
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.mypagePlaceLayout.setOnClickListener{
            val intent = Intent(context,MySpotActivity::class.java)
            intent.putExtra("mySpotList",mySpotList)
            context?.startActivity(intent)
        }

        binding.mypageCourseLayout.setOnClickListener {

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
//        TODO("Not yet implemented")
    }

    override fun onMypageSuccess(response: MypageResponse) {
        when(response.code) {
            1000 -> {
                binding.mypageProfileTv.setText(response.result!![0].memberNickname)
                binding.mypagePlaceNumberTv.setText(response.result!![0].savedSpotCount)
                binding.mypageCourseNumberTv.setText(response.result!![0].savedCourseCount)
            }
        }
    }
}
