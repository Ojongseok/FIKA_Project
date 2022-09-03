package com.fika.fika_project.ui.main.mycourse.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentReviewImgBinding
import com.fika.fika_project.utils.spfManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson

class ReviewImgFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentReviewImgBinding? = null
    private val binding get() = _binding!!
    val gson : Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentReviewImgBinding.inflate(inflater, container, false)
        onClickListener()

        setView()
        return binding.root
    }

    private fun setView() {
        val reviewImg = spfManager.getImgUrl()
        Glide.with(requireContext()).load(reviewImg).into(binding.dialogReviewIv)
    }

    private fun onClickListener(){
        binding.dialogReviewCloseIv.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }

        binding.dialogReviewLayout.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}