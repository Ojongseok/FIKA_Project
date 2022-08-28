package com.example.fika_project.ui.main.hold_and_scrap

import android.util.Log
import android.widget.ImageView
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationHoldService(val View: LocationHoldView, private val filter : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val token = ApplicationClass.X_ACCESS_TOKEN

    val load = retrofit.postLocationHold(token,filter)
    fun tryLoadLocationHold(iv : ImageView){
        load.enqueue(object : Callback<LocationHoldResponse> {
            override fun onResponse(call: Call<LocationHoldResponse>, response: Response<LocationHoldResponse>) {
                val resp = response.body()

                Log.d("LOADEXPLORE/API", response.body().toString())

                when(resp?.code){
                    1012 -> {
                        View.onExploreSuccess(response.body() as LocationHoldResponse, iv)
                        Log.d("LOADEXPLORE", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<LocationHoldResponse>, t: Throwable) {
                View.onExploreFailure(400,t.message?:"LOADEXPLORE/API-ERROR")
                Log.d("LOADEXPLORE/API-ERROR", t.toString())
            }
        })
    }
}