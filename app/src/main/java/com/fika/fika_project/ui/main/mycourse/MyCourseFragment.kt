package com.fika.fika_project.ui.main.mycourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.FragmentMycourseBinding
import com.fika.fika_project.retrofit.GroupName
import com.fika.fika_project.ui.login.BasicResponse
import com.fika.fika_project.ui.main.home.myCourseList
import com.google.android.material.snackbar.Snackbar

class MyCourseFragment :Fragment(), MyCourseView {
    private lateinit var binding: FragmentMycourseBinding
    val service = MyCourseService(this)

    // 데이터를 담을 List
    private val data: MutableList<ExpandableListAdapter.Item> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMycourseBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        service.tryMyCourse()
//        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "${response.result[0].groupName}"))
//        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "${response.result[0].coursePreviewList!![0].courseTitle}"))

        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "새로운 그룹 1"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "새로운 그룹1 - 1"))

        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, "새로운 그룹 2"))
        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, "새로운 그룹2 - 1"))

        binding.mycourseExpandListRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.mycourseExpandListRecyclerview.adapter = ExpandableListAdapter(requireContext(), data)


        binding.addGroupBtn.setOnClickListener {
            val getGroupName = GroupName(binding.addGroupEt.text.toString())
            service.tryAddGroup(getGroupName)
        }

        binding.editGroupNameBtn.setOnClickListener {

        }
    }

//    private fun setMyCourseRVAdapter(coursePreviewList: ArrayList<MyCourse>){
//        binding.mycourseExpandListRecyclerview.layoutManager = LinearLayoutManager(requireContext())
//        binding.mycourseExpandListRecyclerview.adapter = ExpandableListAdapter(coursePreviewList, requireContext())
//        binding.mycourseExpandListRecyclerview.setHasFixedSize(false)
//    }

    override fun onLoading() {
        binding.mycoursePb.visibility = View.VISIBLE
    }

    override fun onMyCourseSuccess(response: MyCourseResponse) {
        binding.mycoursePb.visibility = View.GONE

        when(response.code) {
                1000 -> {
                    if(response.result!!.size == 0){
                        binding.mycourseExpandListRecyclerview.visibility = View.GONE
                        binding.myscrapcourseEmptyIv.visibility = View.VISIBLE
                    }else{
//                        response.let { setMyCourseRVAdapter(it.result!!) }
                    }
                }

        }
    }

    override fun onAddGroupSuccess(response: BasicResponse) {
        when(response.code){
          1000 -> {
              Snackbar.make(requireView(), "${response.result} 그룹이 생성되었습니다!", Snackbar.LENGTH_SHORT
              ).setAction("Action", null).show()
          }
          }
    }
}