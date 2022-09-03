package com.example.fika_project.ui.main.mycourse

import com.example.fika_project.ui.main.home.HomeResponse

interface MyCourseView {
    fun onMyCourseLoading()
    fun onMyCourseSuccess(response: MyCourseResponse)
}
