package com.fika.fika_project.ui.main.mycourse

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityReviewWriteBinding
import com.fika.fika_project.ui.main.mycourse.visit_course.VisitCourse

class ReviewWriteActivity : AppCompatActivity() {
    private var _Binding: ActivityReviewWriteBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDataLoad()
        binding.reviewWriteCompleteBtn.setOnClickListener {
            Toast.makeText(this,"리뷰 작성이 완료되었습니다.",Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.visitCourseBackBtn.setOnClickListener { finish() }
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
        binding.reviewStar1.setOnClickListener {
            binding.reviewStar1.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar2.setImageResource(R.drawable.ic_star_off)
            binding.reviewStar3.setImageResource(R.drawable.ic_star_off)
            binding.reviewStar4.setImageResource(R.drawable.ic_star_off)
            binding.reviewStar5.setImageResource(R.drawable.ic_star_off)
        }
        binding.reviewStar2.setOnClickListener {
            binding.reviewStar1.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar2.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar3.setImageResource(R.drawable.ic_star_off)
            binding.reviewStar4.setImageResource(R.drawable.ic_star_off)
            binding.reviewStar5.setImageResource(R.drawable.ic_star_off)
        }
        binding.reviewStar3.setOnClickListener {
            binding.reviewStar1.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar2.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar3.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar4.setImageResource(R.drawable.ic_star_off)
            binding.reviewStar5.setImageResource(R.drawable.ic_star_off)
        }
        binding.reviewStar4.setOnClickListener {
            binding.reviewStar1.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar2.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar3.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar4.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar5.setImageResource(R.drawable.ic_star_off)
        }
        binding.reviewStar5.setOnClickListener {
            binding.reviewStar1.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar2.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar3.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar4.setImageResource(R.drawable.ic_star_on)
            binding.reviewStar5.setImageResource(R.drawable.ic_star_on)
        }
    }



    private fun initDataLoad() {
        val spotInfo = intent.getSerializableExtra("list") as VisitCourse
        Glide.with(this).load(spotInfo.spotImageUrl).into(binding.reviewWriteIv)
        binding.reviewWriteTv1.text = spotInfo.shortAddress
        binding.reviewWriteTv2.text = spotInfo.type
        binding.childTitle.text = spotInfo.spotTitle
        if (spotInfo.reviewPosted) {
            binding.locageTv.visibility = View.VISIBLE
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