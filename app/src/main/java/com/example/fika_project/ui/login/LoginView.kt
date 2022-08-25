package com.example.fika_project.ui.login

interface LoginView {
    fun onLoading()

    fun onKakaoSuccess(response: LoginResponse)
}