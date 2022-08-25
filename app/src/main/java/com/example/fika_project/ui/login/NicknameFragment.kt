package com.example.fika_project.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fika_project.databinding.FragmentAgree03Binding
import com.example.fika_project.databinding.FragmentNicknameBinding

class NicknameFragment  : Fragment() {
    private var _binding: FragmentNicknameBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNicknameBinding.inflate(inflater, container, false)

        initClickListener()

        return binding.root
    }

    private fun initClickListener(){
        val lActivity = activity as LoginActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}