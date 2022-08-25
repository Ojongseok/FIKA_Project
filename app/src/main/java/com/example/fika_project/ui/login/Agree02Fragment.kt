package com.example.fika_project.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fika_project.databinding.FragmentAgree02Binding

class Agree02Fragment  : Fragment() {
    private var _binding: FragmentAgree02Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAgree02Binding.inflate(inflater, container, false)

        initClickListener()

        return binding.root
    }

    private fun initClickListener(){
        val lActivity = activity as LoginActivity

        binding.agree02CountinueBtn.setOnClickListener{
            lActivity.changeFragment(1)
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