package com.fika.fika_project.ui.main.explore.filter_drama

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
    @SerializedName("dramaId") var dramaId: Int?,
    @SerializedName("dramaTitle") var dramaTitle : String?,
    @SerializedName("thumbnailUrl") var thumbnailUrl : String?
) : Serializable
