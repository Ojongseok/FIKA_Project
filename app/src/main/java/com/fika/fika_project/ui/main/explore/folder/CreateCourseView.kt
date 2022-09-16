package com.fika.fika_project.ui.main.explore.folder

interface CreateCourseView {
    fun onExploreLoading()
    fun onExploreSuccess(response: CreateCourseResponse)
    fun onExploreFailure()
}