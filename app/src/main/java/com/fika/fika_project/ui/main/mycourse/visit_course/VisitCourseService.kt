package com.fika.fika_project.ui.main.mycourse.visit_course

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VisitCourseService(val View: VisitCourseView, val courseid : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    
    fun tryloadVisitCourse(){
        View.onLoading()

        retrofit.loadVisitCourse(courseid).enqueue(object : Callback<VisitCourseResponse> {
            override fun onResponse(call: Call<VisitCourseResponse>, response: Response<VisitCourseResponse>) {
                val result : VisitCourseResponse? = response.body()
                val resp = response.body()

                Log.d("LOADHOME/API", result.toString())

                when(resp?.code){
                    1000 -> {
                        View.onVisitSuccess(response.body() as VisitCourseResponse)
                        Log.d("LOADHOME", "성공.")
                    }
                }
            }

            override fun onFailure(call: Call<VisitCourseResponse>, t: Throwable) {
                Log.d("LOADHOME/API-ERROR", t.toString())
            }
        })
    }
}