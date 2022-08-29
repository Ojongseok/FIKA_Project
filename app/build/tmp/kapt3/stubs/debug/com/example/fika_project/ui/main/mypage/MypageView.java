package com.example.fika_project.ui.main.mypage;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/example/fika_project/ui/main/mypage/MypageView;", "", "onLoading", "", "onMyScrapSuccess", "response", "Lcom/example/fika_project/ui/main/mypage/MyScrapResponse;", "onMypageSuccess", "Lcom/example/fika_project/ui/main/mypage/MypageResponse;", "app_debug"})
public abstract interface MypageView {
    
    public abstract void onLoading();
    
    public abstract void onMypageSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.mypage.MypageResponse response);
    
    public abstract void onMyScrapSuccess(@org.jetbrains.annotations.NotNull()
    com.example.fika_project.ui.main.mypage.MyScrapResponse response);
}