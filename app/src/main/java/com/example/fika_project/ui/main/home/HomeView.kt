package com.example.fika_project.ui.main.home

interface HomeView {
    fun onHomeLoading()
    fun onHomeSuccess(response: HomeResponse)
    fun onHomeFailure(code: Int, message: String)
}