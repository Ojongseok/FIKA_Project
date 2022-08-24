package com.example.fika_project.ui.main.explore.drama_info

import com.example.fika_project.ui.main.explore.DramaInfoResponse

interface DramaInfoView {
    fun onExploreLoading()
    fun onExploreSuccess(response: DramaInfoResponse)
    fun onExploreFailure(code: Int, message: String)
}