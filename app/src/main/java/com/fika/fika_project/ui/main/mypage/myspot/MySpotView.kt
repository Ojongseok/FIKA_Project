package com.fika.fika_project.ui.main.mypage.myspot

interface MySpotView {
    fun onExploreLoading()
    fun onExploreSuccess(response: MySpotResponse)
    fun onExploreFailure(code: Int, message: String)
}