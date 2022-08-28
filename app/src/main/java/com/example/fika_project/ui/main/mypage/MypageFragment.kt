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
import com.example.fika_project.ui.main.mypage.myspot.MySpotActivity

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
                val resp = response.result!!

                val spot = resp.savedSpotCount.toString()
                val course = resp.savedCourseCount.toString()

                binding.mypageProfileTv.setText(resp.memberNickname)
                binding.mypagePlaceNumberTv.text = spot+"개"
                binding.mypageCourseNumberTv.text = course + "개"
            }
            else ->{
                binding.mypageProfileTv.setText("FIKA")
            }
        }
    }
}
