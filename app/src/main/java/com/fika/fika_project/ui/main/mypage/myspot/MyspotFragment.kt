package com.fika.fika_project.ui.main.mypage

import androidx.fragment.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentMyholdcourseBinding
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.ui.main.mypage.myspot.*
import kotlinx.android.synthetic.main.fragment_myholdcourse.view.*
import kotlinx.android.synthetic.main.item_myplace.view.*

class MyholdcourseFragment : Fragment(),MySpotView {
    private var _binding: FragmentMyholdcourseBinding? = null
    private val binding get() = _binding!!
    val service = MySpotService(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMyholdcourseBinding.inflate(inflater, container, false)

        service.tryloadMySpot()

        onClickListener()


        return binding.root
    }


    private fun onClickListener() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.myplaceBackIv.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }

        val mActivity = activity as MainActivity
        binding.myplaceHomeIv.setOnClickListener {
            mActivity.changeFragment(1)
        }


    }

    override fun onExploreLoading() {
        binding.myscrapcourseEmptyPb.visibility = View.VISIBLE
    }

    override fun onExploreSuccess(response: MySpotResponse) {
        binding.myscrapcourseEmptyPb.visibility = View.GONE

        when(response.code) {
            1000 -> {
                if (response.result!!.size == 0) {
                    binding.myscrapcourseEmptyIv.visibility = View.VISIBLE
                    binding.myplaceRv.visibility = View.GONE
                } else {
                    response.let {
                        binding.myscrapcourseEmptyIv.visibility = View.GONE
                        binding.myplaceRv.visibility = View.VISIBLE

                        binding.myplaceRv.layoutManager = LinearLayoutManager(requireContext())
                        binding.myplaceRv.adapter = MyspotRVAdapter(it.result!!, requireContext())
                    }
                }
            }
        }
    }

    override fun onExploreFailure(code: Int, message: String) {
    }
}

