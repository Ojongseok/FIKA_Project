package com.example.fika_project.ui.main.explore.todrama

interface ExploreDramaView {
    fun onExploreLoading()
    fun onExploreSuccess(response: ExploreDramaResponse)
    fun onExploreFailure(code: Int, message: String)
}