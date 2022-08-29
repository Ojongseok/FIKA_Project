package com.example.fika_project.ui.main.explore.drama_info

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import com.example.fika_project.ui.main.explore.DramaInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DramaInfoService(val View: DramaInfoView, val dramaId : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val load = retrofit.loadDramaInfoCourse(dramaId)

    fun tryLoadDramaInfoCourse(){
        load.enqueue(object : Callback<DramaInfoResponse> {
            override fun onResponse(call: Call<DramaInfoResponse>, response: Response<DramaInfoResponse>) {
                val resp = response.body()

                Log.d("load/API", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as DramaInfoResponse)
                        Log.d("load", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<DramaInfoResponse>, t: Throwable) {
                Log.d("load/API-ERROR", t.toString())
            }
        })
    }
}