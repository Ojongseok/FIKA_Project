package com.fika.fika_project.ui.main.mycourse.visit_course

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityVisitCompleteCourseBinding
import com.fika.fika_project.ui.main.mycourse.ReviewDialog
import com.fika.fika_project.ui.main.mycourse.ReviewWriteActivity
import kotlinx.android.synthetic.main.visit_complete_course_list.view.*

class VisitCompleteCourse : AppCompatActivity(),VisitCourseView {
    private var _Binding: ActivityVisitCompleteCourseBinding? = null
    private val binding get() = _Binding!!
    var courseId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityVisitCompleteCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        courseId = intent.getIntExtra("courseId",0)
        val service = VisitCourseService(this,courseId)
        service.tryloadVisitCourse()

        binding.visitCourseBackBtn.setOnClickListener { finish() }
    }
    override fun onVisitSuccess(response: VisitCourseResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    binding.visitCompleteCourseRecyclerview.layoutManager = LinearLayoutManager(this)
                    binding.visitCompleteCourseRecyclerview.adapter = VisitCompleteCourseAdapter(this,it.result!!)
                }
            }
        }
    }
    inner class VisitCompleteCourseAdapter(val context: Context, val list : ArrayList<VisitCourse>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.visit_complete_course_list,parent,false)

            return CustomViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val view = (holder as CustomViewHolder).itemView

            Glide.with(context).load(list[position].spotImageUrl).into(view.course_detail_iv)
            view.map_title_name_tv.text = list[position].spotTitle
            view.course_detail_where_tv.text = list[position].shortAddress
            view.course_detail_category_tv.text = list[position].type
            Log.d("리뷰",list[position].reviewPosted.toString())
            if (list[position].reviewPosted) {
                view.visit_complete_visit_iv.visibility = View.GONE
                view.visit_complete_review_tv.text = "작성 완료"
            } else {
                view.visit_complete_visit_iv.visibility = View.VISIBLE
                view.visit_complete_review_tv.text = "리뷰"
            }

            view.visit_complete_review_write_btn.setOnClickListener {
                if (list[position].reviewPosted) {
                    val dialog = ReviewDialog(context)
                    dialog.showDialog()
                } else {
                    val intent = Intent(context,ReviewWriteActivity::class.java)
                    intent.putExtra("list",list[position])
                    startActivity(intent)
                }

            }


        }
        inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
        override fun getItemCount() = list.size
    }
    override fun onLoading() {
    }
    override fun onVisitFailure() {}
}