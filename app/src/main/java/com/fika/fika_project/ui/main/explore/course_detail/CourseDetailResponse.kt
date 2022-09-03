package com.fika.fika_project.ui.main.explore.course_detail

import com.google.gson.annotations.SerializedName

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
    @SerializedName("locageSceneDescribe") val locageSceneDescribe : String?,
    @SerializedName("hashTag") val hashTag : String?,
    @SerializedName("locageSceneImageUrl") val locageSceneImageUrl : String?,
    @SerializedName("dramaTitle") val dramaTitle : String?,
    @SerializedName("baseAddress") val baseAddress : String?,
    @SerializedName("courseLocage") val courseLocage : courseLocage?,
    @SerializedName("spotList") val spotList : ArrayList<spotList>?,
    @SerializedName("courseSavedCount") val courseSavedCount : Int?
)
data class courseLocage(
    @SerializedName("spotId") val spotId: Int?,
    @SerializedName("spotImageUrl") val spotImageUrl : String?,
    @SerializedName("shortAddress") val shortAddress : String?,
    @SerializedName("type") val type : String?,
    @SerializedName("spotTitle") val spotTitle : String?,
    @SerializedName("spotSavedCount") val spotSavedCount : Int?,
    @SerializedName("mapX") val mapX : Double?,
    @SerializedName("mapY") val mapY : Double?,
    @SerializedName("scrapped") val scrapped : Boolean?,
    @SerializedName("locage") val locage : Boolean?
)
data class spotList(
    @SerializedName("spotId") val spotId: Int?,
    @SerializedName("spotImageUrl") val spotImageUrl : String?,
    @SerializedName("shortAddress") val shortAddress : String?,
    @SerializedName("type") val type : String?,
    @SerializedName("spotTitle") val spotTitle : String?,
    @SerializedName("spotSavedCount") val spotSavedCount : Int?,
    @SerializedName("mapX") val mapX : Double?,
    @SerializedName("mapY") val mapY : Double?,
    @SerializedName("scrapped") val scrapped : Boolean?,
    @SerializedName("locage") val locage : Boolean?
)