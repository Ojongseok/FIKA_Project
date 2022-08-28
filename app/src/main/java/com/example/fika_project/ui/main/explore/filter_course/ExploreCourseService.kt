package com.example.fika_project.ui.main.explore.filter_course

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import com.example.fika_project.ui.main.explore.ExploreCourseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreCourseService(val View: ExploreCourseView, val filter : String) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val loadExploreCourse = retrofit.loadCourseFilter(filter)
    fun tryLoadExploreCourse(){
        loadExploreCourse.enqueue(object : Callback<ExploreCourseResponse> {
            override fun onResponse(call: Call<ExploreCourseResponse>, response: Response<ExploreCourseResponse>) {
                val resp = response.body()

                Log.d("LOADEXPLORE/API", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as ExploreCourseResponse)
                        Log.d("LOADEXPLORE", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<ExploreCourseResponse>, t: Throwable) {
                View.onExploreFailure(400,t.message?:"LOADEXPLORE/API-ERROR")
                Log.d("LOADEXPLORE/API-ERROR", t.toString())
            }
        })
    }
}