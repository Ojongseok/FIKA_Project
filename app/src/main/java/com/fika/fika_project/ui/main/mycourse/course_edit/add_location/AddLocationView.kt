package com.fika.fika_project.ui.main.mycourse.course_edit.add_location

import com.fika.fika_project.ui.main.explore.AddLocationResponse

interface AddLocationView {
    fun onExploreLoading()
    fun onExploreSuccess(response: AddLocationResponse)
    fun onExploreFailure(code: Int, message: String)
}