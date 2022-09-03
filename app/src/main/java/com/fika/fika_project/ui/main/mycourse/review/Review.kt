package com.fika.fika_project.ui.main.mycourse.review

data class Review (
    var id: Int = 0,
    var nickname: String? = "",
    var score : Int? = null,
    var date : String? = "",
    var reviewImg: Int? = null,
    var contents: String?
)