package com.example.fika_project.ui.main.mycourse.placeinfo

import com.google.gson.annotations.SerializedName

data class PlaceInfoResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: PlaceInfo?,
    @SerializedName("httpStatus") val httpStatus: String?
    )

data class PlaceInfo (
    @SerializedName("dialogImageUrl") val dialogImageUrl: String,
    @SerializedName("hashTag") val hashTag: String,
    @SerializedName("spotImageUrl") val spotImageUrl: String,
    @SerializedName("spotTitle") val spotTitle: String,
    @SerializedName("type") val type: String,
    @SerializedName("timeOpened") val timeOpened: String?,
    @SerializedName("address") val address: String,
    @SerializedName("mapX") val mapX: Double,
    @SerializedName("mapY") val mapY: Double,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("reviewCount") val reviewCount: Int,
    @SerializedName("reviewRateAverage") val reviewRateAverage: Double,
    @SerializedName("spotMenuList") val spotMenuList: ArrayList<MenuList>?,
    @SerializedName("reviewList") val reviewList: ArrayList<ReviewList>,
    @SerializedName("locage") val locage: Boolean,
    @SerializedName("scrapped") val scrapped: Boolean,
    )

data class MenuList (
    @SerializedName("menuName") val menuName: String,
    @SerializedName("menuPrice") val menuPrice: String
)

data class ReviewList (
    @SerializedName("reviewId") val reviewId: Int,
    @SerializedName("spotDataId") val spotDataId: Int,
    @SerializedName("spotDataTitle") val spotDataTitle: String,
    @SerializedName("rate") val rate: Int,
    @SerializedName("userNickname") val userNickname: String,
    @SerializedName("reviewContents") val reviewContents: String,
    @SerializedName("imageUrls") val imageUrls: ArrayList<String>?,
    @SerializedName("createAt") val createAt: String,
    @SerializedName("imageReview") val imageReview: Boolean,
)


data class ReportResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: String,
    @SerializedName("httpStatus") val httpStatus: String
)
