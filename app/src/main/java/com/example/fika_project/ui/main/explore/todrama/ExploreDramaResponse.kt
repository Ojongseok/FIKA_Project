package com.example.fika_project.ui.main.explore.todrama

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ExploreDramaResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean?,
    @SerializedName("code") val code: Int?,
    @SerializedName("message") val message: String?,
    @SerializedName("result") val result: ArrayList<result>?,
    @SerializedName("httpStatus") val httpStatus: String?
)

data class result(
    @SerializedName("dramaId") val dramaId: Int?,
    @SerializedName("dramaTitle") val dramaTitle : String?,
    @SerializedName("thumbnailUrl") val thumbnailUrl : String?
) : Serializable
