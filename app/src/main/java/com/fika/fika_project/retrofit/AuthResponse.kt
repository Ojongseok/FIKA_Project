package com.fika.fika_project.retrofit

import com.google.gson.annotations.SerializedName


data class AuthResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: Auth?
)

data class Auth(@SerializedName("jwt") val jwt: String)

data class HomeResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<HomeContens>?
)

data class HomeContens(
    @SerializedName("senderIdx") val senderIdx: Int?,
    @SerializedName("recipientIdx") val recipientIdx: Int?,
    @SerializedName("date") val date: String?,
    @SerializedName("contents") val contents: String?,
    @SerializedName("ischecked") val ischecked: Int?,
    @SerializedName("recipientNickname") val recipient: String?,
    @SerializedName("senderNickname") val sender: String?
)
