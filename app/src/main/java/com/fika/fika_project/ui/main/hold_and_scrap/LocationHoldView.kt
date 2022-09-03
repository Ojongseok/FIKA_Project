package com.fika.fika_project.ui.main.hold_and_scrap

import android.widget.ImageView

interface LocationHoldView {
    fun onExploreLoading()
    fun onExploreSuccess(response: LocationHoldResponse, iv : ImageView)
    fun onExploreFailure(code: Int, message: String)
}