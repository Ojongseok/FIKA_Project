package com.example.fika_project.ui.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: String?,
)
