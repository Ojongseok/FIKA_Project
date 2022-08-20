package com.example.fika_project.ui.main.explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.FragmentExploreCoursePageBinding

class ExploreCoursePage : Fragment() {
    private var _binding: FragmentExploreCoursePageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentExploreCoursePageBinding.inflate(inflater, container, false)

        binding.exploreCoursePageRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.exploreCoursePageRecyclerview.adapter = ExploreCoursePageAdapter(requireContext())

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}