package com.example.fika_project.ui.login

interface LoginView {
    fun onLoading()

    // 1. 카카오 로그인
    fun onKakaoSuccess(response: KakaoResponse)
}