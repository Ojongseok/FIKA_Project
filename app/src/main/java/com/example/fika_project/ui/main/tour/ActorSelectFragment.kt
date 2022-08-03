package com.example.fika_project.ui.main.tour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentTourActorSelectBinding
import com.example.fika_project.databinding.FragmentTourBinding

class ActorSelectFragment : Fragment() {
    private var _binding: FragmentTourActorSelectBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTourActorSelectBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}