package com.fika.fika_project.ui.main.explore.course_detail

interface CourseDetailView {
    fun onExploreLoading()
    fun onExploreSuccess(response: CourseDetailResponse)
    fun onExploreFailure(code: Int, message: String)
}