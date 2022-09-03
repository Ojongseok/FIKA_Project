package com.fika.fika_project.ui.main.mycourse.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.fika.fika_project.databinding.FragmentReviewReportBinding
import com.fika.fika_project.retrofit.ReviewReport
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceInfoResponse
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceinfoService
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceinfoView
import com.fika.fika_project.ui.main.mycourse.placeinfo.ReportResponse
import com.fika.fika_project.utils.spfManager

class ReviewReportFragment: Fragment(),PlaceinfoView {
    private var _binding: FragmentReviewReportBinding? = null
    private val binding get() = _binding!!

    val service = PlaceinfoService(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentReviewReportBinding.inflate(inflater, container, false)

        onClickListener()

        return binding.root
    }

    private fun onClickListener(){
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        binding.reviewReportBackBtn.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }

        binding.reviewReportBtn.setOnClickListener {
            val reviewId = spfManager.getReviewId()!!.toInt()
            val reportType = ""
            val reportDetail = binding.reviewReportDetailEt.toString()

            val getReport = ReviewReport(reviewId,reportType,reportDetail)
            service.tryReviwReport(getReport)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onLoading() {
        TODO("Not yet implemented")
    }

    override fun onPlaceinfoSuccess(response: PlaceInfoResponse) {
        //없는 함수
    }

    override fun onReviewReportSuccess(response: ReportResponse) {
        Toast.makeText(requireContext(),"신고 완료!",Toast.LENGTH_SHORT)
    }
}