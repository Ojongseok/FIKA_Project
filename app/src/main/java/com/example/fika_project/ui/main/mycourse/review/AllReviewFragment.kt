package com.example.fika_project.ui.main.mycourse.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentAllReviewBinding
import com.example.fika_project.ui.main.MainActivity
import com.example.fika_project.ui.main.mycourse.placeinfo.*
import com.example.fika_project.utils.spfManager
import com.google.gson.Gson

class AllReviewFragment: Fragment(), PlaceinfoView {
    private var _binding: FragmentAllReviewBinding? = null
    private val binding get() = _binding!!
    val courseId = spfManager.getCourseId()!!.toInt()
    val service = PlaceinfoService(this)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAllReviewBinding.inflate(inflater, container, false)

        onClickListener()

        service.tryPlaceinfo(courseId)
        return binding.root
    }

    private fun onClickListener(){
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        binding.allViewBackBtn.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
    }


    private fun setAdapter(reviewList: ArrayList<ReviewList>) {
        val allReviewRVAdapter = AllReviewRVAdapter(reviewList,requireContext())
        binding.allReviewRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.allReviewRv.adapter = allReviewRVAdapter
        binding.allReviewRv.setHasFixedSize(false)

        allReviewRVAdapter.setMyItemClickListener(object : AllReviewRVAdapter.MyItemClickListener{
            override fun onItemMoreClick(position: Int) {
                viewReviewReportFrag()
            }
        })
    }

    private fun viewReviewReportFrag() {
        (context as PlaceinfoActivity).supportFragmentManager.beginTransaction()
            .add(R.id.placeinfo_locate_frm, ReviewReportFragment())
            .commitAllowingStateLoss()
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onPlaceinfoSuccess(response: PlaceInfoResponse) {
        when(response.code){
            1000 -> {
                response?.let { setAdapter(it.result!!.reviewList) }
                binding.allViewSubTitleNumTv.text = response.result!!.reviewCount.toString()
            }
        }
    }

    override fun onReviewReportSuccess(response: ReportResponse) {
        //없는 함수
    }
}