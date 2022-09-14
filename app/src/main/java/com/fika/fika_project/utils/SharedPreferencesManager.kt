package com.fika.fika_project.utils

import com.fika.fika_project.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.fika.fika_project.ApplicationClass.Companion.prefs

object spfManager {
    val editor = prefs.edit()

    fun saveKakaoJwt(kakaoToken: String?) {
        editor.putString("kakaoToken" , kakaoToken).apply()
    }

    fun getKakaoJwt(): String {
        return prefs.getString("kakaoToken", "").toString()
    }

    fun RemoveKakaoJwt() {
        prefs.edit().remove("kakaoToken").apply()
    }

    fun setJwt(jwtToken: String?) {
        editor.putString(X_ACCESS_TOKEN, jwtToken).apply()
    }

    fun getJwt(): String? {
        return prefs.getString(X_ACCESS_TOKEN, "").toString()
    }

    fun setDramaId(dramaId: Int) { editor.putInt("dramaId", dramaId).apply() }
    fun getDramaId(): Int? { return prefs.getInt("dramaId", 0) }

    fun setEmail(email: String) { editor.putString("Email", email).apply() }
    fun getEmail(): String? = prefs.getString("Email", "")

    fun setNickname(nickname: String) { editor.putString("Nickname", nickname).apply() }
    fun getNickname(): String? = prefs.getString("Nickname", "")

    fun setCourseId(courseId: Int) { editor.putInt("courseId", courseId).apply() }
    fun getCourseId(): Int? { return prefs.getInt("courseId", 0) }

    fun setReviewId(reviewId: Int) { editor.putInt("reviewId", reviewId).apply() }
    fun getReviewId(): Int? { return prefs.getInt("reviewId", 0) }

    fun setImgUrl(imgUrl: String) { editor.putString("imgUrl", imgUrl).apply() }
    fun getImgUrl(): String? { return prefs.getString("imgUrl", "").toString() }

    fun ClearSpf() {
        prefs.edit().clear().commit()
    }

}
