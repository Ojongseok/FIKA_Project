package com.example.fika_project.ui.main.explore.course_detail

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseDetailService(val View: CourseDetailView, val courseId : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val token = ApplicationClass.X_ACCESS_TOKEN
    val load = retrofit.loadDetailCourse(token, 36)
    fun tryLoadCourseDetail(){
        load.enqueue(object : Callback<CourseDetailResponse> {
            override fun onResponse(call: Call<CourseDetailResponse>, response: Response<CourseDetailResponse>) {
                val resp = response.body()
                Log.d("coursedetail1/API", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as CourseDetailResponse)
                        Log.d("coursedetail1", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<CourseDetailResponse>, t: Throwable) {
                View.onExploreFailure(400,t.message?:"LOADEXPLORE/API-ERROR")
                Log.d("coursedetail1/API-ERROR", t.toString())
            }
        })
    }
}