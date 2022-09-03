package com.fika.fika_project.ui.main.mycourse

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyCourseService (val View: MyCourseView){
        val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

        fun tryMyCourse(){
            retrofit.MyCourse().enqueue(object : Callback<MyCourseResponse> {
                override fun onResponse(call: Call<MyCourseResponse>, response: Response<MyCourseResponse>) {
                    val result : MyCourseResponse? = response.body()
                    val resp = response.body()

                    Log.d("MYCOURSE/API", result.toString())

                    when(resp?.code){
                        1000 -> {
                            View.onMyCourseSuccess(response.body() as MyCourseResponse)
                            Log.d("MYCOURSE", "성공.")
                        }
                        4000 -> { Log.d("MYCOURSE", "Access-Token이 존재하지 않는 경우") }
                        4001 -> { Log.d("MYCOURSE", "유효하지 않은 AccessToken") }
                        4002 -> { Log.d("MYCOURSE", "만료된 토큰") }
                        4020 -> { Log.d("MYCOURSE", "필수값이 포함되지 않은 경우") }
                    }
                }

                override fun onFailure(call: Call<MyCourseResponse>, t: Throwable) {
                    Log.d("MYCOURSE/API-ERROR", t.toString())
                }
            })
        }
}