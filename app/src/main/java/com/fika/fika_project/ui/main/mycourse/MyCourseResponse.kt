package com.fika.fika_project.ui.main.mycourse

import com.google.gson.annotations.SerializedName

data class MyCourseResponse (
   @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<MyCourse>?,
    @SerializedName("httpStatus") val httpStatus: String
)

data class MyCourse (
    @SerializedName("groupId") val groupId: Int,
    @SerializedName("groupName") val groupName: String,
    @SerializedName("coursePreviewList") var coursePreviewList: ArrayList<coursePreviewList>?
)

data class coursePreviewList (
    @SerializedName("courseId") val courseId: Int,
    @SerializedName("locageImageUrl") val locageImageUrl: String,
    @SerializedName("courseTitle") val courseTitle: String,
    @SerializedName("dramaTitle") val dramaTitle: String,
    @SerializedName("baseAddress") val baseAddress: String,
    @SerializedName("spotTitleList") val spotTitleList: List<String>,
    @SerializedName("courseSavedCount") val courseSavedCount: Int,
    @SerializedName("scrapped") val scrapped: Boolean
)