package com.example.fika_project.ui.main.mypage

import com.google.gson.annotations.SerializedName

data class MypageResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<Mypage>?,
    @SerializedName("httpStatus") val httpStatus: String?
    )

data class Mypage(
    @SerializedName("memberNickname") val memberNickname: String,
    @SerializedName("savedSpotCount") val savedSpotCount: Int,
    @SerializedName("savedCourseCount") val savedCourseCount: Int
)