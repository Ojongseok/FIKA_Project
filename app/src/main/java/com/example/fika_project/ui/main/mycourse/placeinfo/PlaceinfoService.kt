package com.example.fika_project.ui.main.mycourse.placeinfo

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import com.example.fika_project.ui.login.KakaoResponse
import com.example.fika_project.ui.login.LoginView
import com.example.fika_project.utils.spfManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceinfoService (val View : PlaceinfoView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun tryPlaceinfo(spotId: Int){
        retrofit.placeInfo(spotId).enqueue(object : Callback<PlaceInfoResponse> {
            override fun onResponse(call: Call<PlaceInfoResponse>, response: Response<PlaceInfoResponse>) {
                var result: PlaceInfoResponse? = response.body()
                val resp = response.body()

                Log.d("PLACEINFO/API-RESPONSE", result.toString())

                when(resp?.code){
                    //성공
                    1000 -> {
                        View.onPlaceinfoSuccess(response.body() as PlaceInfoResponse)
                        Log.d("PLACEINFO/1000", resp.message)
                    }

                    4020 -> { Log.d("PLACEINFO/4020", "필수값이 포함되지 않은 경우") }
                    4026 -> { Log.d("PLACEINFO/4026", "spotId가 숫자가 아닌경우") }
                    else ->  {
                        Log.d("PLACEINFO", "실패 : 오류")
                    } }
            }

            override fun onFailure(call: Call<PlaceInfoResponse>, t: Throwable) {
                Log.d("PLACEINFO-FAIL", "PLACEINFO 실패 : 서버 오류")
            }
        })}
}