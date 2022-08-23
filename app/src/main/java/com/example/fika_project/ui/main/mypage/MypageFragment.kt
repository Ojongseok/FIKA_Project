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
import com.example.fika_project.ui.main.mycourse.course_edit.MyHoldLocationActivity

class MypageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)

        onClickListener()

        return binding.root
    }

    private fun onClickListener(){
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.mypageCourseLayout.setOnClickListener{
            fragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.mypage_frm, MyscrapcourseFragment())
            }
        }

        binding.mypagePlaceLayout.setOnClickListener {
            fragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.mypage_frm, MyplaceFragment())
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
}