package com.example.fika_project.ui.main.explore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentExploreBinding
import com.example.fika_project.ui.main.explore.filter_course.ExploreCoursePage
import com.example.fika_project.ui.main.explore.filter_drama.ExploreDramaPage
import com.example.fika_project.ui.main.mycourse.search.SearchActivity

class ExploreFragment:Fragment() {
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        binding.exploreDramaTv.setOnClickListener {
            binding.exploreDramaClickCircle.visibility = View.VISIBLE
            binding.exploreCourseClickCircle.visibility = View.INVISIBLE
            parentFragmentManager.beginTransaction().replace(R.id.explore_main_container,
                ExploreDramaPage()
            ).commit()
        }
        binding.exploreCourseTv.setOnClickListener {
            binding.exploreDramaClickCircle.visibility = View.INVISIBLE
            binding.exploreCourseClickCircle.visibility = View.VISIBLE
            parentFragmentManager.beginTransaction().replace(R.id.explore_main_container,
                ExploreCoursePage()
            ).commit()
        }

        binding.button2.setOnClickListener {
            startActivity(Intent(requireContext(),SearchActivity::class.java))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.beginTransaction().replace(R.id.explore_main_container,
            ExploreDramaPage()
        ).commit()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}