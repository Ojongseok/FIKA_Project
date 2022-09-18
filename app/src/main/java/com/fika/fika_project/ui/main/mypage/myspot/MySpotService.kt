package com.fika.fika_project.ui.main.mypage.myspot

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MySpotService(val View: MySpotView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val load = retrofit.loadMySpot()

    fun tryloadMySpot(){
        View.onExploreLoading()

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