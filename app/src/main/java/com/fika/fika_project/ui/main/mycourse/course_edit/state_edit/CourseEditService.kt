package com.fika.fika_project.ui.main.mycourse.course_edit.state_edit

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.CourseEditDTO
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseEditService(val View: CourseEditView, val courseId : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun tryCourseEdit(courseEditDTO : CourseEditDTO){
        retrofit.loadCourseEdit(courseId, courseEditDTO).enqueue(object : Callback<CourseEditResponse> {
            override fun onResponse(call: Call<CourseEditResponse>, response: Response<CourseEditResponse>) {
                val resp = response.body()
                Log.d("coursedetail122", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as CourseEditResponse)
                        Log.d("coursedetail122", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<CourseEditResponse>, t: Throwable) {
                Log.d("coursedetail122", "실패")
            }
        })
    }
}