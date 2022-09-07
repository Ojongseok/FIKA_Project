package com.fika.fika_project.ui.main.mycourse.course_edit.state_edit

interface CourseEditView {
    fun onExploreSuccess(response: CourseEditResponse)
    fun onExploreFailure()
}