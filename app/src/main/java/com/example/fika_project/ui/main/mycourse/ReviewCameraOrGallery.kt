package com.example.fika_project.ui.main.mycourse

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.fika_project.databinding.FragmentReviewCameraOrGalleryBinding

class ReviewCameraOrGallery : Fragment() {
    private var _binding: FragmentReviewCameraOrGalleryBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentReviewCameraOrGalleryBinding.inflate(inflater, container, false)

        binding.cameraOrGalleryLayout.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
        binding.startGalleryBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent,2000)
        }

        return binding.root
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != Activity.RESULT_OK) {
            Toast.makeText(context,"잘못된 접근입니다 1",Toast.LENGTH_SHORT).show()
            return
        }

        when(requestCode) {
            2000 -> {
                val selectedImageURI : Uri? = data?.data
                if( selectedImageURI != null) {
                    val intent = Intent()
                    intent.putExtra("result","asd")
                    activity?.setResult(Activity.RESULT_OK,intent)
                    parentFragmentManager.beginTransaction().remove(this).commit()
                }else {
                    Toast.makeText(context,"사진을 가져오지 못했습니다",Toast.LENGTH_SHORT).show()
                }
            } else -> {
            Toast.makeText(context,"잘못된 접근입니다 2",Toast.LENGTH_SHORT).show()
            }
        }
    }
}