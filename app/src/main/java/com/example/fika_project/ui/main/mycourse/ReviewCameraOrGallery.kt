package com.example.fika_project.ui.main.mycourse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentMycourseBinding
import com.example.fika_project.databinding.FragmentReviewCameraOrGalleryBinding

class ReviewCameraOrGallery : Fragment() {
    private var _binding: FragmentReviewCameraOrGalleryBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentReviewCameraOrGalleryBinding.inflate(inflater, container, false)

        binding.cameraOrGalleryLayout.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }

        return binding.root
    }
}