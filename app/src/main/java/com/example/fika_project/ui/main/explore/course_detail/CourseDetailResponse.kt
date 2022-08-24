package com.example.fika_project.ui.main.explore.course_detail

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CourseDetailResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: result?,
    @SerializedName("httpStatus") val httpStatus: String?
)

data class result(
    @SerializedName("courseId") val courseId: Int?,
    @SerializedName("courseTitle") val courseTitle : String?,
    @SerializedName("dramaId") val dramaId : Int?,
    @SerializedName("dramaTitle") val dramaTitle : String?,
    @SerializedName("baseAddress") val baseAddress : String?,
    @SerializedName("spotList") val spotList : ArrayList<spotList>?,
    @SerializedName("courseSavedCount") val courseSavedCount : Int?
)
data class spotList(
    @SerializedName("spotId") val spotId: Int?,
    @SerializedName("spotImageUrl") val spotImageUrl : String?,
    @SerializedName("shortAddress") val shortAddress : String?,
    @SerializedName("type") val type : String?,
    @SerializedName("spotTitle") val spotTitle : String?,
    @SerializedName("spotSavedCount") val spotSavedCount : ArrayList<spotList>?,
    @SerializedName("mapX") val mapX : Double?,
    @SerializedName("mapY") val mapY : Double?,
    @SerializedName("locage") val locage : Boolean?
)