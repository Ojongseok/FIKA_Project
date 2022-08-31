package com.example.fika_project.ui.main.mycourse

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.FragmentMycourseBinding

class MyCourseFragment :Fragment() {
    private lateinit var binding: FragmentMycourseBinding
    // 데이터를 담을 List
    private val data: MutableList<ExpandableListAdapter.Item> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMycourseBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "기본 그룹"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "기본 그룹 - 1"))

        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "새로운 그룹 1"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "새로운 그룹1 - 1"))

        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "새로운 그룹 2"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "새로운 그룹2 - 1"))

        binding.mycourseExpandListRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.mycourseExpandListRecyclerview.adapter = ExpandableListAdapter(requireContext(), data)

        binding.addGroupBtn.setOnClickListener {

        }
        binding.editGroupNameBtn.setOnClickListener {

        }
    }
}