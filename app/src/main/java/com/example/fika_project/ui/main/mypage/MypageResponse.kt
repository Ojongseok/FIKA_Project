package com.example.fika_project.ui.main.mypage

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MypageResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Mypage?,
    @SerializedName("httpStatus") val httpStatus: String?
    ) : Serializable

data class Mypage(
    @SerializedName("memberNickname") val memberNickname: String,
    @SerializedName("savedSpotCount") val savedSpotCount: Int,
    @SerializedName("savedCourseCount") val savedCourseCount: Int
): Serializable