package com.fika.fika_project.ui.main.mycourse.review

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentAllReviewBinding
import com.fika.fika_project.ui.main.mycourse.placeinfo.*
import com.fika.fika_project.utils.spfManager

class AllReviewFragment: Fragment(), PlaceinfoView {
    private var _binding: FragmentAllReviewBinding? = null
    private val binding get() = _binding!!
    val service = PlaceinfoService(this)

    private var isChecked: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAllReviewBinding.inflate(inflater, container, false)

        onClickListener()

        val homeSpotId = spfManager.getCourseId()!!.toInt()

        service.tryPlaceinfo(homeSpotId)
        return binding.root
    }

    private fun onClickListener(){
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        binding.allViewBackBtn.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }

        binding.allReviewLookPhotoCb.setOnClickListener {
            isChecked = !isChecked

            if(isChecked){
                binding.allReviewLookPhotoCb.setImageResource(R.drawable.ic_checkbox_off)
            }else{
                binding.allReviewLookPhotoCb.setImageResource(R.drawable.ic_checkbox_on)
            }
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
        binding.allReviewPb.visibility = View.VISIBLE
    }

    override fun onPlaceinfoSuccess(response: PlaceInfoResponse) {
        binding.allReviewPb.visibility = View.GONE

        when(response.code){
            1000 -> {
                response.let { setAdapter(it.result!!.reviewList) }
                binding.allViewSubTitleNumTv.text = response.result!!.reviewCount.toString()

                if(response.result.reviewCount == 0){
                    binding.allReviewEmptyTv.visibility = View.VISIBLE
                    binding.allReviewRv.visibility = View.GONE
                } else {
                    binding.allReviewEmptyTv.visibility = View.GONE
                    binding.allReviewRv.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onReviewReportSuccess(response: ReportResponse) {
        //없는 함수
    }
}