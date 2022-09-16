package com.fika.fika_project.ui.main.explore.folder

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CreateCourseResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: Int?,
    @SerializedName("httpStatus") val httpStatus: String?
)