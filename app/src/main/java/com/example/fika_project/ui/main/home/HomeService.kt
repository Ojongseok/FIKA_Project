package com.example.fika_project.ui.main.home

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val View: HomeView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val loadhome = retrofit.loadHome("eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJtZW1iZXJJZCI6MywibWVtYmVyRW1haWwiOiJ0ZXN0ZXJAdGVzdC5jb20iLCJpYXQiOjE2NjEyNDMyNjEsImV4cCI6MTY2MTg0ODA2MX0.3CLhVPdl4UmPJf5TTvQ5Z2mm_XGruXh7GL6aX4nCynI")

    fun tryLoadHome(){
        loadhome.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {

                val result : HomeResponse? = response.body()
                val resp = response.body()

                Log.d("LOADHOME/API", result.toString())

                when(resp?.code){
                    1000 -> {
                        View.onHomeSuccess(response.body() as HomeResponse)
                        Log.d("LOADHOME", "성공.")
                    }
                }
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                View.onHomeFailure(400,t.message?:"LOADHOME/API-ERROR")
                Log.d("LOADHOME/API-ERROR", t.toString())
            }
        })
    }
}