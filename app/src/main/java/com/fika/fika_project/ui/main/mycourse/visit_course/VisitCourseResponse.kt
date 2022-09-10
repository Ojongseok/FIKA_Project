package com.fika.fika_project.ui.main.mycourse.visit_course

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class VisitCourseResponse (
   @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<VisitCourse>?,
    @SerializedName("httpStatus") val httpStatus: String
)

data class VisitCourse (
    @SerializedName("spotId") val spotId: Int,
    @SerializedName("spotImageUrl") val spotImageUrl: String,
    @SerializedName("shortAddress") val shortAddress: String,
    @SerializedName("type") val type: String,
    @SerializedName("spotTitle") val spotTitle: String,
    @SerializedName("spotSavedCount") val spotSavedCount: Int,
    @SerializedName("mapX") val mapX: Double,
    @SerializedName("mapY") val mapY: Double,
    @SerializedName("scrapped") val scrapped: Boolean,
    @SerializedName("reviewPosted") val reviewPosted: Boolean,
    @SerializedName("locage") val locage: Boolean,
) : Serializable