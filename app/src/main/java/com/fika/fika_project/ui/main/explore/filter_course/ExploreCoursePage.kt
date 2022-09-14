package com.fika.fika_project.ui.main.explore.filter_course

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.FragmentExploreCoursePageBinding
import com.fika.fika_project.ui.main.explore.*

class ExploreCoursePage : Fragment(), ExploreCourseView {
    private var _binding: FragmentExploreCoursePageBinding? = null
    private val binding get() = _binding!!
    var filter : String = "all"
    val service = ExploreCourseService(this,filter)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentExploreCoursePageBinding.inflate(inflater, container, false)

        binding.filterCoursePageBtn1.setOnClickListener {
            val menuList =arrayOf("전체","梨泰院クラス","愛の不時着")
            val dialog = AlertDialog.Builder(requireContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar)
            dialog.setTitle("드라마").setItems(menuList, DialogInterface.OnClickListener { dialogInterface, i ->
                binding.filerCourseTv1.text = menuList[i]

            })
            dialog.show()
        }
        binding.filterCoursePageBtn2.setOnClickListener {
            val menuList =arrayOf("전체","キム・ダミ","パク・ソジュン","アン・ボヒョン")
            val dialog = AlertDialog.Builder(requireContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar)
            dialog.setTitle("배우").setItems(menuList, DialogInterface.OnClickListener { dialogInterface, i ->
                binding.filterCourseTv2.text = menuList[i]

            })
            dialog.show()
        }
        binding.filterCourseSortingBtn.setOnClickListener {
            val menuList =arrayOf("最新順","スクラップの多い順")
            val dialog = AlertDialog.Builder(requireContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar)
            dialog.setTitle("정렬").setItems(menuList, DialogInterface.OnClickListener { dialogInterface, i ->
                binding.filterSortTvCourse.text = menuList[i]

            })
            dialog.show()
        }
        service.tryLoadExploreCourse()
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onExploreLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onExploreSuccess(response: ExploreCourseResponse) {
        when(response.code) {
            1000 -> {
                binding.progressBar.visibility = View.GONE
                response.let {
                    response?.let { setDramalist(it.result!!) }
                }
            }
        }
    }
    private fun setDramalist(dramalist : ArrayList<course>) {
        binding.exploreCoursePageRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.exploreCoursePageRecyclerview.adapter = ExploreCoursePageAdapter(dramalist, requireContext())
        binding.exploreCoursepageSearchNumber.text = dramalist.size.toString() + "つ"
    }

    override fun onExploreFailure(code: Int, message: String) {
    }
}