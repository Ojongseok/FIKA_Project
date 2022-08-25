package com.example.fika_project.ui.main.mypage.myspot

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MySpotResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: ArrayList<result>?,
    @SerializedName("httpStatus") val httpStatus: String?
)

data class result(
    @SerializedName("spotId") val spotId: Int?,
    @SerializedName("spotImageUrl") val spotImageUrl : String?,
    @SerializedName("shortAddress") val shortAddress : String?,
    @SerializedName("type") val type : String?,
    @SerializedName("spotTitle") val spotTitle : String?,
    @SerializedName("spotSavedCount") val spotSavedCount : Int?,
    @SerializedName("mapX") val mapX : Double?,
    @SerializedName("mapY") val mapY : Double?,
    @SerializedName("scrapped") val scrapped : Boolean?,
    @SerializedName("locage") val locage : Boolean?,
)
