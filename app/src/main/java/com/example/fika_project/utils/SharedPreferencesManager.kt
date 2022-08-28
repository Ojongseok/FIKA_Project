package com.example.fika_project.utils

import com.example.fika_project.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.fika_project.ApplicationClass.Companion.prefs

object spfManager {
    val editor = prefs.edit()

    fun saveKakaoJwt(kakaoToken: String?) {
        editor.putString("kakaoToken", kakaoToken).apply()
    }

    fun getKakaoJwt(): String {
        return prefs.getString("kakaoToken", "").toString()
    }

    fun setJwt(jwtToken: String) { editor.putString(X_ACCESS_TOKEN, jwtToken).apply() }
    fun getJwt(): String? { return prefs.getString(X_ACCESS_TOKEN, "").toString()}

    fun setEmail(email: String) { editor.putString("Email", email).apply() }
    fun getEmail(): String? = prefs.getString("Email", "")

    fun setNickname(nickname: String) { editor.putString("Nickname", nickname).apply() }
    fun getNickname(): String? = prefs.getString("Nickname", "")
}
