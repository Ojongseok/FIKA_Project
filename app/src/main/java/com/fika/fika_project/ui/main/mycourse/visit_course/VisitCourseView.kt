package com.fika.fika_project.ui.main.mycourse.visit_course


interface VisitCourseView {
    fun onLoading()
    fun onVisitSuccess(response: VisitCourseResponse)
    fun onVisitFailure()
}
