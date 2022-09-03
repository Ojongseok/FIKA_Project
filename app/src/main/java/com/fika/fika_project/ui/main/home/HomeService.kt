package com.fika.fika_project.ui.main.home

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val View: HomeView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun tryLoadHome(){
        retrofit.loadHome().enqueue(object : Callback<HomeResponse> {
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