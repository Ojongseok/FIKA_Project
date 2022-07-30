package com.example.fika_project.ui.main.tour
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentTourBinding
import kotlinx.android.synthetic.main.fragment_tour.*

class TourFragment :Fragment() {
    private var _binding: FragmentTourBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTourBinding.inflate(inflater, container, false)

        spinnerSetting()

        val recyclerviewManager = GridLayoutManager(activity,3)
        val recyclerAdapter = TourRecyclerviewAdapter(this)
        binding.tourRecyclerview.apply {
            layoutManager = recyclerviewManager
            adapter = recyclerAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun spinnerSetting() {
        val spinnerGenre = binding.tourSpinnerGenre
        val spinnerActor = binding.tourSpinnerActor
        val spinnerSort = binding.tourSpinnerSort
        spinnerGenre.adapter = ArrayAdapter.createFromResource(requireContext(),R.array.genre,android.R.layout.simple_spinner_item)
        spinnerActor.adapter = ArrayAdapter.createFromResource(requireContext(),R.array.actor,android.R.layout.simple_spinner_item)
        spinnerSort.adapter = ArrayAdapter.createFromResource(requireContext(),R.array.sort,android.R.layout.simple_spinner_item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}