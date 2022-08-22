package com.example.fika_project.ui.login

import com.example.fika_project.retrofit.AuthResponse

interface LoginView {
    fun onLoginLoading()
    fun onLoginSuccess(response: AuthResponse)
    fun onLoginFailure(code: Int, message: String)
}