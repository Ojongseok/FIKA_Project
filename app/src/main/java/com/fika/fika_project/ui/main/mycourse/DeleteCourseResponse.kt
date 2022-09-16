package com.fika.fika_project.ui.main.mycourse

import com.google.gson.annotations.SerializedName

data class DeleteCourseResponse (
   @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Int?,
    @SerializedName("httpStatus") val httpStatus: String
)