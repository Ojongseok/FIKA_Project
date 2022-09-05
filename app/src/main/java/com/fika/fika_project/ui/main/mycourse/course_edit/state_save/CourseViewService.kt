package com.fika.fika_project.ui.main.mycourse.course_edit.state_save

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CourseViewService(val View: CourseViewView, val courseId : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val load = retrofit.loadCourseView(courseId)
    fun tryCourseView(){
        load.enqueue(object : Callback<CourseViewResponse> {
            override fun onResponse(call: Call<CourseViewResponse>, response: Response<CourseViewResponse>) {
                val resp = response.body()
                Log.d("coursedetail1/API", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as CourseViewResponse)
                        Log.d("coursedetail1", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<CourseViewResponse>, t: Throwable) {
                View.onExploreFailure()
                Log.d("coursedetail1/API-ERROR", t.toString())
            }
        })
    }
}