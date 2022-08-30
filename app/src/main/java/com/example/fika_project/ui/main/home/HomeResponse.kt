package com.example.fika_project.ui.main.home

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HomeResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Home?,
    @SerializedName("httpStatus") val httpStatus: String
)

data class Home(
    @SerializedName("myCourseList") val myCourseList: ArrayList<myCourseList>?,
    @SerializedName("dramaList") val dramaList: ArrayList<dramaList>?,
    @SerializedName("coursesSortBySaved") val coursesSortBySaved: ArrayList<coursesSortBySaved>?,
    @SerializedName("spotsSortBySaved") val spotsSortBySaved: ArrayList<spotsSortBySaved>?
)

data class myCourseList (
    @SerializedName("courseId") val courseId: Int?,
    @SerializedName("locageImageUrl") val locageImageUrl: String?,
    @SerializedName("courseTitle") val courseTitle: String?,
    @SerializedName("dramaTitle") val dramaTitle: String?,
    @SerializedName("baseAddress") val baseAddress: String?,
    @SerializedName("spotTitleList") val spotTitleList: ArrayList<String>?,
    @SerializedName("courseSavedCount") val courseSavedCount: Int?,
    @SerializedName("scrapped") val scrapped: Boolean?
)

data class dramaList (
    @SerializedName("dramaId") val dramaId: Int?,
    @SerializedName("dramaTitle") val dramaTitle: String?,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String?
    ) : Serializable

data class coursesSortBySaved (
    @SerializedName("courseId") val courseId: Int?,
    @SerializedName("locageImageUrl") val locageImageUrl: String?,
    @SerializedName("courseTitle") val courseTitle: String?,
    @SerializedName("dramaTitle") val dramaTitle: String?,
    @SerializedName("baseAddress") val baseAddress: String?,
    @SerializedName("spotTitleList") val spotTitleList: ArrayList<String>?,
    @SerializedName("courseSavedCount") val courseSavedCount: Int?,
    @SerializedName("scrapped") val scrapped: Boolean?
)

data class spotsSortBySaved (
    @SerializedName("spotId") val spotId: Int?,
    @SerializedName("spotImageUrl") val spotImageUrl: String?,
    @SerializedName("shortAddress") val shortAddress: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("spotTitle") val spotTitle: String?,
    @SerializedName("spotSavedCount") val spotSavedCount: Int?,
    @SerializedName("mapX") val mapX: Double?,
    @SerializedName("mapY") val mapY: Double?,
    @SerializedName("scrapped") val scrapped: Boolean?,
    @SerializedName("locage") val locage: Boolean?
)
