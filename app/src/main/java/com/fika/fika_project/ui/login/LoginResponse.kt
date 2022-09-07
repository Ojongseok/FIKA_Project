package com.fika.fika_project.ui.login

import com.google.gson.annotations.SerializedName
import java.io.Serializable

//1. 카카오 로그인
//20. 소셜 인증 후 회원가입
data class BasicResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: String,
    @SerializedName("httpStatus") val httpStatus: String
) : Serializable

//4. 닉네임 유효성 검사
data class AuthResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Boolean?,
    @SerializedName("httpStatus") val httpStatus: String
    ) : Serializable
