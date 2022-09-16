package com.fika.fika_project.ui.login

interface LoginView {
    fun onLoading()

    // 1. 카카오 로그인
    fun onKakaoSuccess(response: BasicResponse)

    // 31. 테스터 로그인
    fun onTesterSuccess(response: BasicResponse)

    // 37. 구글 로그인
    fun onGoogleSuccess(response: BasicResponse)
}