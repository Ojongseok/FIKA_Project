package com.fika.fika_project.ui.main.hold_and_scrap

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LocationHoldResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("httpStatus") val httpStatus: String?
) : Serializable