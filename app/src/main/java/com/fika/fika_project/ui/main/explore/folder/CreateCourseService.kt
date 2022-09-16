package com.fika.fika_project.ui.main.explore.folder

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.AddCourseDTO
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateCourseService(val View: CreateCourseView,val course : AddCourseDTO) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val load = retrofit.loadCreateCourse(course)
    fun tryCreateCourse(){
        View.onExploreLoading()
        load.enqueue(object : Callback<CreateCourseResponse> {
            override fun onResponse(call: Call<CreateCourseResponse>, response: Response<CreateCourseResponse>) {
                val resp = response.body()

                Log.d("LOADEXPLORE/API", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as CreateCourseResponse)
                        Log.d("LOADEXPLORE", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<CreateCourseResponse>, t: Throwable) {
                Log.d("LOADEXPLORE/API-ERROR", t.toString())
            }
        })
    }
}