package com.fika.fika_project.ui.main.explore.folder

interface FolderView {
    fun onExploreSuccess(response: FolderResponse)
    fun onExploreFailure()
}