package com.fika.fika_project.ui.main.explore.filter_drama

interface ExploreDramaView {
    fun onExploreLoading()
    fun onExploreSuccess(response: ExploreDramaResponse)
    fun onExploreFailure(code: Int, message: String)
}