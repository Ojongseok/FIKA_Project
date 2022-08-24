package com.example.fika_project.ui.main.explore.todrama

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fika_project.databinding.FragmentExploreDramaPageBinding

class ExploreDramaPage : Fragment(), ExploreDramaView {
    private var _binding: FragmentExploreDramaPageBinding? = null
    private val binding get() = _binding!!
    val service = ExploreService(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentExploreDramaPageBinding.inflate(inflater, container, false)


        service.tryLoadExploreDrama()
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onExploreLoading() {
    }
    override fun onExploreSuccess(response: ExploreDramaResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    response?.let { setDramalist(it.result!!) }
                }
            }
        }
    }
    private fun setDramalist(dramalist: ArrayList<result>) {
        binding.exploreDramaPageRecyclerview.layoutManager = GridLayoutManager(requireContext(),3)
        binding.exploreDramaPageRecyclerview.adapter = ExploreDramaPageAdapter(dramalist, requireContext())

    }
    override fun onExploreFailure(code: Int, message: String) {
    }
}