package com.fika.fika_project.ui.main.mycourse.placeinfo

interface PlaceinfoView {
    fun onLoading()

    // 20. 장소 상세 조회
    fun onPlaceinfoSuccess(response: PlaceInfoResponse)
    // 20. 장소 상세 조회
    fun onReviewReportSuccess(response: ReportResponse)
}