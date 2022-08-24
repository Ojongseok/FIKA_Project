package com.example.fika_project.ui.main.explore.tocourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.FragmentExploreCoursePageBinding
import com.example.fika_project.ui.main.explore.*

class ExploreCoursePage : Fragment(), ExploreCourseView {
    private var _binding: FragmentExploreCoursePageBinding? = null
    private val binding get() = _binding!!
    val service = ExploreCourseService(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentExploreCoursePageBinding.inflate(inflater, container, false)



        service.tryLoadExploreCourse()
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onExploreLoading() {
    }

    override fun onExploreSuccess(response: ExploreCourseResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    response?.let { setDramalist(it.result!!) }
                }
            }
        }
    }
    private fun setDramalist(dramalist : ArrayList<course>) {
        binding.exploreCoursePageRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.exploreCoursePageRecyclerview.adapter = ExploreCoursePageAdapter(dramalist, requireContext())
    }

    override fun onExploreFailure(code: Int, message: String) {
    }
}