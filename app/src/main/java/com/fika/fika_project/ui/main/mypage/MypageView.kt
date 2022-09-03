package com.fika.fika_project.ui.main.mypage

interface MypageView {
    fun onLoading()

    // 25. 마이페이지 조회
    fun onMypageSuccess(response: MypageResponse)


    fun onMyScrapSuccess(response: MyScrapResponse)
}