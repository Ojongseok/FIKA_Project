package com.example.fika_project.ui.login

import com.google.gson.annotations.SerializedName
import java.io.Serializable

//1. 카카오 로그인
//4. 닉네임 유효성 검사
//20. 소셜 인증 후 회원가입
data class AuthResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: String,
    @SerializedName("httpStatus") val httpStatus: String?
    ) : Serializable
