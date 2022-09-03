package com.fika.fika_project.ui.main.explore

import com.google.gson.annotations.SerializedName

data class ExploreCourseResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: ArrayList<course>?,
    @SerializedName("httpStatus") val httpStatus: String?
)
data class course(
    @SerializedName("courseId") val courseId : Int?,
    @SerializedName("locageImageUrl") val locageImageUrl : String?,
    @SerializedName("courseTitle") val courseTitle : String?,
    @SerializedName("dramaTitle") val dramaTitle : String?,
    @SerializedName("baseAddress") val baseAddress : String?,
    @SerializedName("spotTitleList") val spotTitleList : ArrayList<String>?,
    @SerializedName("courseSavedCount") val courseSavedCount : Int?,
    @SerializedName("scrapped") val scrapped : Boolean?
)