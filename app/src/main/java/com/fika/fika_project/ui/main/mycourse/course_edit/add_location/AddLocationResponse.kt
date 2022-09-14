package com.fika.fika_project.ui.main.explore

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AddLocationResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: ArrayList<location>?,
    @SerializedName("httpStatus") val httpStatus: String?
)
data class location(
    @SerializedName("courseId") val courseId : Int?,
    @SerializedName("locageImageUrl") val locageImageUrl : String?,
    @SerializedName("shortAddress") val shortAddress : String?,
    @SerializedName("type") val type : String?,
    @SerializedName("spotTitle") val spotTitle : String?,
    @SerializedName("spotSavedCount") val spotSavedCount : Int?,
    @SerializedName("mapX") val mapX : Double?,
    @SerializedName("mapY") val mapY : Double?,
    @SerializedName("scrapped") val scrapped : Boolean?,
    @SerializedName("locage") val locage : Boolean?
) : Serializable