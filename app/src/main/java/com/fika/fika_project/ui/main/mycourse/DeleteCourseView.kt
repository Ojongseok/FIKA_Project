package com.fika.fika_project.ui.main.mycourse

import com.fika.fika_project.ui.login.BasicResponse

interface DeleteCourseView {
    fun onLoading()
    fun onDeleteCourseSuccess(response: DeleteCourseResponse)
}
