package com.fika.fika_project.ui.main.hold_and_scrap

import android.util.Log
import android.widget.ImageView
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationHoldService(val View: LocationHoldView, private val filter : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    val load = retrofit.postLocationHold(filter)
    fun tryLoadLocationHold(iv : ImageView){
        load.clone().enqueue(object : Callback<LocationHoldResponse> {
            override fun onResponse(call: Call<LocationHoldResponse>, response: Response<LocationHoldResponse>) {
                val resp = response.body()
                Log.d("LOADEXPLORE/API", response.body().toString())

                when(resp?.code){
                    1012 -> {
                        View.onExploreSuccess(response.body() as LocationHoldResponse, iv)
                        Log.d("LOADEXPLORE", "성공.1")
                    }
                    1013 -> {
                        View.onExploreSuccess(response.body() as LocationHoldResponse, iv)
                        Log.d("LOADEXPLORE", "성공.2")
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