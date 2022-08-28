package com.example.fika_project.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/fika_project/ui/login/NicknameView;", "", "onLoading", "", "onNicknameCheckSuccess", "response", "Lcom/example/fika_project/ui/login/AuthResponse;", "onSignUpSuccess", "Lcom/example/fika_project/ui/login/KakaoResponse;", "app_debug"})
public abstract interface NicknameView {
    
    public abstract void onLoading();
    
    public abstract void onNicknameCheckSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.login.AuthResponse response);
    
    public abstract void onSignUpSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.login.KakaoResponse response);
}