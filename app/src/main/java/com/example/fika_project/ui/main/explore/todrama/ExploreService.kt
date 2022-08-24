package com.example.fika_project.ui.main.explore.todrama

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExploreService(val View: ExploreDramaView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val token = ApplicationClass.X_ACCESS_TOKEN
    val loadExploreDrama = retrofit.loadDramaFilter(token)
    fun tryLoadExploreDrama(){
        loadExploreDrama.enqueue(object : Callback<ExploreDramaResponse> {
            override fun onResponse(call: Call<ExploreDramaResponse>, response: Response<ExploreDramaResponse>) {
                val resp = response.body()

                Log.d("LOADEXPLORE/API", response.body().toString())

                when(resp?.code){
                    1000 -> {
                        View.onExploreSuccess(response.body() as ExploreDramaResponse)
                        Log.d("LOADEXPLORE", "성공.")
                    }
                }
            }
            override fun onFailure(call: Call<ExploreDramaResponse>, t: Throwable) {
                View.onExploreFailure(400,t.message?:"LOADEXPLORE/API-ERROR")
                Log.d("LOADEXPLORE/API-ERROR", t.toString())
            }
        })
    }
}