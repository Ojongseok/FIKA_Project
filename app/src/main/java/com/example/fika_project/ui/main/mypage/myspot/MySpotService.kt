package com.example.fika_project.ui.main.mypage.myspot

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MySpotService(val View: MySpotView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val token = ApplicationClass.X_ACCESS_TOKEN
    val load = retrofit.loadMySpot(token)

    fun tryloadMySpot(){
        load.enqueue(object : Callback<MySpotResponse> {
            override fun onResponse(call: Call<MySpotResponse>, response: Response<MySpotResponse>) {
                val resp = response.body()

                Log.d("LOADEXPLORE/API", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as MySpotResponse)
                        Log.d("LOADEXPLORE", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<MySpotResponse>, t: Throwable) {
                View.onExploreFailure(400,t.message?:"LOADEXPLORE/API-ERROR")
                Log.d("LOADEXPLORE/API-ERROR", t.toString())
            }
        })
    }
}