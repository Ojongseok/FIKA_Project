package com.example.fika_project.utils

import com.example.fika_project.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.fika_project.ApplicationClass.Companion.prefs

fun saveJwt(jwtToken: String) {
    val editor = prefs.edit()
    editor.putString(X_ACCESS_TOKEN, jwtToken)

    editor.apply()
}

fun getJwt(): String? = prefs.getString(X_ACCESS_TOKEN, null)
