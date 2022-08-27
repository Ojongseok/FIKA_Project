package com.example.fika_project.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fika_project.databinding.FragmentAgree01Binding

class Agree01Fragment  : Fragment() {
    private var _binding: FragmentAgree01Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAgree01Binding.inflate(inflater, container, false)

        initClickListener()

        return binding.root
    }

    private fun initClickListener(){
        val lActivity = activity as LoginActivity

        binding.agree01BackBtn.setOnClickListener{
            lActivity.changeFragment(1)
        }
        binding.agree01More03.setOnClickListener {
            lActivity.changeFragment(3)
        }
        binding.agree01More04.setOnClickListener {
            lActivity.changeFragment(4)
        }
        binding.agree01CountinueBtn.setOnClickListener {
            lActivity.changeFragment(5)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}