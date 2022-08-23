package com.example.fika_project.retrofit

import retrofit2.Call
import retrofit2.http.POST

interface RetrofitInterface {
    //카카오 로그인
    @POST("/oauth/login/kakao")
    fun kakaoLogin(): Call<AuthResponse>
}