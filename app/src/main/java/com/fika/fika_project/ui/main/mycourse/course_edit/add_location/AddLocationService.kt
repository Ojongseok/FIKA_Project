package com.fika.fika_project.ui.main.mycourse.course_edit.add_location

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.AddLocationDTO
import com.fika.fika_project.retrofit.RetrofitInterface
import com.fika.fika_project.ui.main.explore.AddLocationResponse
import com.fika.fika_project.ui.main.explore.ExploreCourseResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddLocationService(val View: AddLocationView,val courseId : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val load = retrofit.loadAddLocation(courseId, AddLocationDTO(ArrayList()))
    fun tryAddLocation(){
        View.onExploreLoading()
        load.enqueue(object : Callback<AddLocationResponse> {
            override fun onResponse(call: Call<AddLocationResponse>, response: Response<AddLocationResponse>) {
                val resp = response.body()
                Log.d("LOADEXPLORE/API", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as AddLocationResponse)
                        Log.d("LOADEXPLORE", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<AddLocationResponse>, t: Throwable) {
                View.onExploreFailure(400,t.message?:"LOADEXPLORE/API-ERROR")
                Log.d("LOADEXPLORE/API-ERROR", t.toString())
            }
        })
    }
}