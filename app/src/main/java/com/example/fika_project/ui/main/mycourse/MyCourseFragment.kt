package com.example.fika_project.ui.main.mycourse
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.FragmentMycourseBinding

class MyCourseFragment :Fragment() {
    private var _binding: FragmentMycourseBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMycourseBinding.inflate(inflater, container, false)


        val data: MutableList<ExpandableListAdapter.Item> = ArrayList() // 데이터를 담을 List
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "기본 그룹"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "우리의 밤은 당신의 낮보다"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "우리의 밤은 당신의 낮보다"))

        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "새로운 그룹 1"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "우리의 밤은 당신의 낮보다"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "우리의 밤은 당신의 낮보다"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "우리의 밤은 당신의 낮보다"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "우리의 밤은 당신의 낮보다"))

        binding.mycourseExpandListRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.mycourseExpandListRecyclerview.adapter = ExpandableListAdapter(data)


        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}