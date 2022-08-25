package com.example.fika_project.ui.main.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentMypageBinding
import com.example.fika_project.ui.main.explore.course_detail.result
import com.example.fika_project.ui.main.explore.filter_drama.ExploreService
import com.example.fika_project.ui.main.mypage.myspot.MySpotActivity
import com.example.fika_project.ui.main.mypage.myspot.MySpotResponse
import com.example.fika_project.ui.main.mypage.myspot.MySpotService
import com.example.fika_project.ui.main.mypage.myspot.MySpotView

class MypageFragment : Fragment(),MySpotView {
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!
    val service = MySpotService(this)
    lateinit var mySpotList : ArrayList<com.example.fika_project.ui.main.mypage.myspot.result>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)

        onClickListener()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service.tryloadMySpot()
    }

    override fun onExploreSuccess(response: MySpotResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    mySpotList = it.result!!
                    binding.mypagePlaceNumberTv.text = it.result?.size.toString() + "개"
                }
            }
        }
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
    override fun onExploreLoading() {
    }
    override fun onExploreFailure(code: Int, message: String) {
    }
}