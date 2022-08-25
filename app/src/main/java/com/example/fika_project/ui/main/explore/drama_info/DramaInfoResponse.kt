package com.example.fika_project.ui.main.explore

import com.google.gson.annotations.SerializedName

data class DramaInfoResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: Drama,
    @SerializedName("httpStatus") val httpStatus: String?
)
data class Drama(
    @SerializedName("dramaTitle") val dramaTitle : String?,
    @SerializedName("genre") val genre : String?,
    @SerializedName("thumbnailUrl") val thumbnailUrl : String?,
    @SerializedName("spotDataList") val spotDataList : ArrayList<spotDataList>?,
    @SerializedName("courseList") val courseList : ArrayList<courseList>?,
)
data class spotDataList(
    @SerializedName("spotId") val spotId : Int?,
    @SerializedName("spotImageUrl") val spotImageUrl : String?,
    @SerializedName("shortAddress") val shortAddress : String?,
    @SerializedName("type") val type : String?,
    @SerializedName("spotTitle") val spotTitle : String?,
    @SerializedName("spotSavedCount") val spotSavedCount : Int?,
    @SerializedName("mapX") val mapX : Double?,
    @SerializedName("mapY") val mapY : Double?,
    @SerializedName("locage") val locage : Boolean?
)
data class courseList(
    @SerializedName("courseId") val courseId : Int?,
    @SerializedName("locageImageUrl") val locageImageUrl : String?,
    @SerializedName("courseTitle") val courseTitle : String?,
    @SerializedName("dramaTitle") val dramaTitle : String?,
    @SerializedName("baseAddress") val baseAddress : String?,
    @SerializedName("spotTitleList") val spotTitleList : ArrayList<String>?,
    @SerializedName("courseSavedCount") val courseSavedCount : Int?
)