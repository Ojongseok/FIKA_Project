package com.example.fika_project.ui.main.mypage

import com.example.fika_project.ui.login.KakaoResponse

interface MypageView {
    fun onLoading()

    // 25. 마이페이지 조회
    fun onMypageSuccess(response: MypageResponse)


    fun onMyScrapSuccess(response: MyScrapResponse)
}