package com.fika.fika_project.ui.main.mycourse

import android.os.Bundle
import android.util.Log
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

    private val data: MutableList<ExpandableListAdapter.Item> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMycourseBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        service.tryMyCourse()

        binding.addGroupBtn.setOnClickListener {
            val getGroupName = GroupName("새로운 그룹")
            service.tryAddGroup(getGroupName)
        }

        binding.editGroupNameBtn.setOnClickListener {

        }
    }


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
                    Log.d("TAG",response.result.size.toString())
                    for (i in 0 until response.result.size) {
                        data.add(ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, response.result[i].groupName))
                        for (j in 0 until response.result[i].coursePreviewList!!.size) {
                            data.add(ExpandableListAdapter.Item(
                                ExpandableListAdapter.CHILD,
                                response.result[i].coursePreviewList?.get(j)?.courseTitle,
                                response.result[i].coursePreviewList?.get(j)?.dramaTitle,
                                response.result[i].coursePreviewList?.get(j)?.baseAddress,
                                response.result[i].coursePreviewList?.get(j)?.locageImageUrl,
                                response.result[i].coursePreviewList?.get(j)?.courseId,
                                response.result[i].coursePreviewList?.get(j)?.spotTitleList.toString()
                            ))
                        }
                    }
                    binding.mycourseExpandListRecyclerview.layoutManager = LinearLayoutManager(requireContext())
                    binding.mycourseExpandListRecyclerview.adapter = ExpandableListAdapter(requireContext(), data)
                }
            }

        }
    }

    override fun onAddGroupSuccess(response: BasicResponse) {
        binding.mycoursePb.visibility = View.GONE

        when(response.code){
                1000 -> {
                    binding.mycoursePb.visibility = View.GONE
                    Snackbar.make(requireView(), "${response.result} 그룹이 생성되었습니다!", Snackbar.LENGTH_SHORT
                ).setAction("Action", null).show()
            }
        }
    }
}