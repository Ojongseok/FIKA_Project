package com.example.fika_project.ui.main.home

import com.example.fika_project.retrofit.AuthResponse

interface HomeView {
    fun onHomeLoading()
    fun onHomeSuccess(response: AuthResponse)
    fun onHomeFailure(code: Int, message: String)
}