package com.example.fika_project.ui.main.mycourse.placeinfo

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import com.example.fika_project.retrofit.ReviewReport
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

    fun tryReviwReport(reviewReport: ReviewReport){
        retrofit.ReviewReport(reviewReport).enqueue(object : Callback<ReportResponse> {
            override fun onResponse(call: Call<ReportResponse>, response: Response<ReportResponse>) {
                var result: ReportResponse? = response.body()
                val resp = response.body()

                Log.d("REPORT/API-RESPONSE", result.toString())

                when(resp?.code){
                    //성공
                    1000 -> {

                        Log.d("REPORT/1000", resp.message)
                    }

                    4020 -> { Log.d("REPORT/4020", "필수값이 포함되지 않은 경우") }
                    4300 -> { Log.d("REPORT/4300", "동일한 리뷰에 대해 중복으로 신고하는 경우") }
                    else ->  {
                        Log.d("REPORT", "실패 : 오류")
                    } }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                Log.d("REPORT-FAIL", "REPORT 실패 : 서버 오류")
            }
        })}
}