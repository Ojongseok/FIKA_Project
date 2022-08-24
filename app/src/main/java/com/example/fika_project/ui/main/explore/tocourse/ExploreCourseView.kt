package com.example.fika_project.ui.main.explore.tocourse

import com.example.fika_project.ui.main.explore.ExploreCourseResponse

interface ExploreCourseView {
    fun onExploreLoading()
    fun onExploreSuccess(response: ExploreCourseResponse)
    fun onExploreFailure(code: Int, message: String)
}