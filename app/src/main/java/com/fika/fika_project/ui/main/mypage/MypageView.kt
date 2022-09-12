package com.fika.fika_project.ui.main.mypage

import com.fika.fika_project.ui.main.mypage.myspot.MySpotResponse

interface MypageView {
    fun onLoading()

    // 25. 마이페이지 조회
    fun onMypageSuccess(response: MypageResponse)

    //내가 담은 장소
    fun onMySpotSuccess(response: MySpotResponse)

    //내가 스크랩한 코스
    fun onMyScrapSuccess(response: MyScrapResponse)
}