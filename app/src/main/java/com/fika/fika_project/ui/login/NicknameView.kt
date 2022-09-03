package com.fika.fika_project.ui.login

interface NicknameView {
    fun onLoading()

    // 4. 닉네임 유효성
    fun onNicknameCheckSuccess(response: AuthResponse)
    // 20. 소셜 인증 후 회원가입
    fun onSignUpSuccess(response: KakaoResponse)
}
