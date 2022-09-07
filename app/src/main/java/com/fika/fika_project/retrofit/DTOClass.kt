package com.fika.fika_project.retrofit


data class User(
    var nickname: String?,
    var email: String?
)


data class Nickname(
    var nickname: String
)

data class ReviewReport(
    var reviewId: Int,
    var reportType: String?,
    var reportDetail: String?
)

data class CourseEditDTO(
    val courseTitle : String,
    val spotIdList : ArrayList<Int>
)