package com.fika.fika_project.ui.main.mypage

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MypageResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Mypage?,
    @SerializedName("httpStatus") val httpStatus: String?
    )

data class Mypage(
    @SerializedName("memberNickname") val memberNickname: String,
    @SerializedName("savedSpotCount") val savedSpotCount: Int,
    @SerializedName("savedCourseCount") val savedCourseCount: Int
)

data class MyScrapResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<MyScrap>?,
    @SerializedName("httpStatus") val httpStatus: String?
)

data class MyScrap(
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("locageImageUrl") val locageImageUrl: String?,
    @SerializedName("courseTitle") val courseTitle: String?,
    @SerializedName("dramaTitle") val dramaTitle: String?,
    @SerializedName("baseAddress") val baseAddress: String?,
    @SerializedName("spotTitleList") val spotTitleList: ArrayList<String>?,
    @SerializedName("courseSavedCount") val courseSavedCount: Int?,
    @SerializedName("scrapped") val scrapped: Boolean?
) : Serializable