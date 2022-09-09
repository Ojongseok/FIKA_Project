package com.fika.fika_project.ui.main.mycourse

import com.fika.fika_project.ui.login.BasicResponse

interface MyCourseView {
    fun onLoading()
    fun onMyCourseSuccess(response: MyCourseResponse)
    fun onAddGroupSuccess(response: BasicResponse)

}
