package com.example.fika_project.retrofit

import com.example.fika_project.ui.main.home.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitInterface {
    //카카오 로그인
    @POST("/oauth/login/kakao")
    fun kakaoLogin(): Call<AuthResponse>

    //8. 메인 페이지 데이터 조회
    @GET("/nav/main")
    fun loadHome(
        @Header("Access-Token") token: String
    ): Call<HomeResponse>
}