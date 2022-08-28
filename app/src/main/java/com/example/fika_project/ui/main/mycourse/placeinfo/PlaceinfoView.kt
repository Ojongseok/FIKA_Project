package com.example.fika_project.ui.main.mycourse.placeinfo

import com.example.fika_project.ui.login.KakaoResponse

interface PlaceinfoView {
    fun onLoading()

    // 20. 장소 상세 조회
    fun onPlaceinfoSuccess(response: PlaceInfoResponse)

}