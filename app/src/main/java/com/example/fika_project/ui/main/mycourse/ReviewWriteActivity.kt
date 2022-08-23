package com.example.fika_project.ui.main.mycourse

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            supportFragmentManager.beginTransaction().replace(R.id.review_write_fragment_container,ReviewCameraOrGallery()).commit()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==Activity.RESULT_OK){
            Toast.makeText(this,data?.getStringExtra("result").toString(),Toast.LENGTH_SHORT).show()
//            if (data?.hasExtra("result") == true) {
//                var result = data?.getParcelableExtra<Uri>("result")
//                Log.d("TAG",result.toString())
//            }
//            binding.reviewWriteImageSelectBtn.setImageURI(result)
        }
    }
}