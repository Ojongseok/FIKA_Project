package com.example.fika_project.ui.main.hold_and_scrap

import android.widget.ImageView

interface LocationScrapView {
    fun onExploreLoading()
    fun onExploreSuccess(response: LocationScrapResponse, iv : ImageView)
    fun onExploreFailure(code: Int, message: String)
}