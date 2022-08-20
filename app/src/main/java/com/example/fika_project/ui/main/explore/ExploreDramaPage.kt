package com.example.fika_project.ui.main.explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentExploreDramaPageBinding

class ExploreDramaPage : Fragment() {
    private var _binding: FragmentExploreDramaPageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentExploreDramaPageBinding.inflate(inflater, container, false)

        binding.exploreDramaPageRecyclerview.layoutManager = GridLayoutManager(activity,3)
        binding.exploreDramaPageRecyclerview.adapter = ExploreDramaPageAdapter(requireContext())

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}