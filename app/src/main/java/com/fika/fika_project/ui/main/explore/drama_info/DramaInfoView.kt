package com.fika.fika_project.ui.main.explore.drama_info

import com.fika.fika_project.ui.main.explore.DramaInfoResponse

interface DramaInfoView {
    fun onExploreLoading()
    fun onExploreSuccess(response: DramaInfoResponse)
}