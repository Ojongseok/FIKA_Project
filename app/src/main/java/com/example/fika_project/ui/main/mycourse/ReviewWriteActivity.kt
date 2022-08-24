package com.example.fika_project.ui.main.mycourse

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.net.toUri
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityReviewWriteBinding
import com.example.fika_project.databinding.ActivityVisitCompleteCourseBinding
import java.net.URI

class ReviewWriteActivity : AppCompatActivity() {
    private var _Binding: ActivityReviewWriteBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.reviewWriteImageSelectBtn.setOnClickListener {
            binding.reviewWriteFragmentContainer.visibility = View.VISIBLE

            binding.startGalleryBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_GET_CONTENT)
                intent.type = "image/*"
                startActivityForResult(intent,2000)
            }

            binding.reviewWriteFragmentContainer.setOnClickListener {
                binding.reviewWriteFragmentContainer.visibility = View.INVISIBLE
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != Activity.RESULT_OK) {
            Toast.makeText(this,"잘못된 접근입니다 1",Toast.LENGTH_SHORT).show()
            return
        }
        when(requestCode) {
            2000 -> {
                val selectedImageURI : Uri? = data?.data
                if(selectedImageURI != null) {
                    binding.reviewWriteFragmentContainer.visibility = View.INVISIBLE
                    binding.reviewWriteImageSelectBtn.setImageURI(selectedImageURI)
                }else {
                    Toast.makeText(this,"사진을 가져오지 못했습니다",Toast.LENGTH_SHORT).show()
                }
            } else -> {
            Toast.makeText(this,"잘못된 접근입니다 2",Toast.LENGTH_SHORT).show()
            }
        }
    }
}