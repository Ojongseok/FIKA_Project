package com.example.fika_project.ui.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fika_project.databinding.FragmentMyplaceBinding

class MyplaceFragment: Fragment() {
    private var _binding: FragmentMyplaceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?)
    : View {
        _binding = FragmentMyplaceBinding.inflate(inflater, container, false)

        onClickListener()

        return binding.root
    }

    private fun onClickListener() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.myplaceBackIv.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}