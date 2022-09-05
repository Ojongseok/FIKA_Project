package com.fika.fika_project.ui.main.mycourse.course_edit.state_save

interface CourseViewView {
    fun onExploreSuccess(response: CourseViewResponse)
    fun onExploreFailure()
}