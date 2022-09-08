package com.fika.fika_project.ui.main.mycourse.course_edit.state_edit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentMyCourseEditStateBinding
import com.fika.fika_project.retrofit.CourseEditDTO
import com.fika.fika_project.ui.main.mycourse.course_edit.MyCourseSaveState
import com.fika.fika_project.ui.main.mycourse.course_edit.MyCourseViewActivity
import com.fika.fika_project.ui.main.mycourse.course_edit.state_save.spotList
import com.fika.myapplication.SwipeHelperCallback
import kotlinx.android.synthetic.main.activity_mycourse_view.*

class MyCourseEditState : Fragment(),CourseEditView {
    private var _binding: FragmentMyCourseEditStateBinding? = null
    private val binding get() = _binding!!
    lateinit var spotList : ArrayList<spotList>
    var courseId = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyCourseEditStateBinding.inflate(inflater, container, false)

        MyCourseViewActivity().mycourse_view_add_location.visibility = View.GONE


        return binding.root
    }
    interface returnItems {
        fun getItems() : ArrayList<Long>
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spotList = arguments?.getSerializable("spotList") as ArrayList<spotList>
        courseId = arguments?.getInt("courseId",0)!!

        val service = CourseEditService(this,courseId)
        val recyclerViewAdapter = MyRecyclerViewAdapter(spotList,requireContext())
        binding.editStateRecyclerview.adapter = recyclerViewAdapter

        binding.mycourseEditBtn.setOnClickListener {
            val list = recyclerViewAdapter.getItems()
            service.tryCourseEdit(CourseEditDTO("코스 수정중입니다",list))
            parentFragmentManager.beginTransaction().replace(R.id.mycourse_view_list_container,MyCourseSaveState()
                .apply {
                    val bundle = Bundle()
                    bundle.putInt("courseId",courseId)
                    arguments = bundle
                }).commit()
        }

        // 리사이클러뷰에 스와이프, 드래그 기능 달기
        val swipeHelperCallback = SwipeHelperCallback(recyclerViewAdapter).apply {
            // 스와이프한 뒤 고정시킬 위치 지정
            setClamp(resources.displayMetrics.widthPixels.toFloat() / 4)    // 1080 / 4 = 270
        }
        ItemTouchHelper(swipeHelperCallback).attachToRecyclerView(binding.editStateRecyclerview)
        // 다른 곳 터치 시 기존 선택했던 뷰 닫기
        binding.editStateRecyclerview.setOnTouchListener { _, _ ->
            swipeHelperCallback.removePreviousClamp(binding.editStateRecyclerview)
            false
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onExploreSuccess(response: CourseEditResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    Log.d("TAG","코스 변경 성공")
                }
            }
        }
    }

    override fun onExploreFailure() {
    }
}