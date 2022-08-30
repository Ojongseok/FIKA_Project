package com.example.fika_project.ui.main.hold_and_scrap

import android.util.Log
import android.widget.ImageView
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationScrapService(val View: LocationScrapView, private val filter : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val load = retrofit.postLocationScrap(filter)
    fun tryLoadLocationScrap(iv : ImageView){
        load.clone().enqueue(object : Callback<LocationScrapResponse> {
            override fun onResponse(call: Call<LocationScrapResponse>, response: Response<LocationScrapResponse>) {
                val resp = response.body()
                Log.d("LOADEXPLORE/API", response.body().toString())

                when(resp?.code){
                    1010 -> {
                        View.onExploreSuccess(response.body() as LocationScrapResponse, iv)
                        Log.d("LOADEXPLORE", "성공.1")
                    }
                    1011 -> {
                        View.onExploreSuccess(response.body() as LocationScrapResponse, iv)
                        Log.d("LOADEXPLORE", "성공.2")
                    }
                }
            }
            override fun onFailure(call: Call<LocationScrapResponse>, t: Throwable) {
                View.onExploreFailure(400,t.message?:"LOADEXPLORE/API-ERROR")
                Log.d("LOADEXPLORE/API-ERROR", t.toString())
            }
        })
    }
}