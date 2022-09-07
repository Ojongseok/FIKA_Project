package com.fika.fika_project.ui.main.explore.folder

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FolderResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: ArrayList<result>?,
    @SerializedName("httpStatus") val httpStatus: String?
)
data class result(
    @SerializedName("courseGroupId") var courseGroupId: Int?,
    @SerializedName("courseGroupName") var courseGroupName : String?
) : Serializable
