package com.example.fika_project.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\bH\'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u000b\u001a\u00020\bH\'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u000fH\'J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003H\'J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003H\'J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u001cH\'J\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u000fH\'J\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010!\u001a\u00020\"H\'\u00a8\u0006#"}, d2 = {"Lcom/example/fika_project/retrofit/RetrofitInterface;", "", "Mypage", "Lretrofit2/Call;", "Lcom/example/fika_project/ui/main/mypage/MypageResponse;", "kakaoLogin", "Lcom/example/fika_project/ui/login/KakaoResponse;", "token", "", "loadCourseFilter", "Lcom/example/fika_project/ui/main/explore/ExploreCourseResponse;", "filter", "loadDetailCourse", "Lcom/example/fika_project/ui/main/explore/course_detail/CourseDetailResponse;", "courseId", "", "loadDramaFilter", "Lcom/example/fika_project/ui/main/explore/filter_drama/ExploreDramaResponse;", "loadDramaInfoCourse", "Lcom/example/fika_project/ui/main/explore/DramaInfoResponse;", "dramaId", "loadHome", "Lcom/example/fika_project/ui/main/home/HomeResponse;", "loadMySpot", "Lcom/example/fika_project/ui/main/mypage/myspot/MySpotResponse;", "nicknameCheck", "Lcom/example/fika_project/ui/login/AuthResponse;", "nickname", "Lcom/example/fika_project/retrofit/Nickname;", "placeInfo", "Lcom/example/fika_project/ui/main/mycourse/placeinfo/PlaceInfoResponse;", "spotId", "signUp", "user", "Lcom/example/fika_project/retrofit/User;", "app_debug"})
public abstract interface RetrofitInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/oauth/login/kakao")
    public abstract retrofit2.Call<com.example.fika_project.ui.login.KakaoResponse> kakaoLogin(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Access-Token")
    java.lang.String token);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/member/valid/nickname")
    public abstract retrofit2.Call<com.example.fika_project.ui.login.AuthResponse> nicknameCheck(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.fika_project.retrofit.Nickname nickname);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/nav/main")
    public abstract retrofit2.Call<com.example.fika_project.ui.main.home.HomeResponse> loadHome();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/drama/{filter}")
    public abstract retrofit2.Call<com.example.fika_project.ui.main.explore.filter_drama.ExploreDramaResponse> loadDramaFilter(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "filter")
    java.lang.String filter);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/course/{filter}")
    public abstract retrofit2.Call<com.example.fika_project.ui.main.explore.ExploreCourseResponse> loadCourseFilter(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "filter")
    java.lang.String filter);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/drama/{dramaId}")
    public abstract retrofit2.Call<com.example.fika_project.ui.main.explore.DramaInfoResponse> loadDramaInfoCourse(@retrofit2.http.Path(value = "dramaId")
    int dramaId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "course/detail/{courseId}")
    public abstract retrofit2.Call<com.example.fika_project.ui.main.explore.course_detail.CourseDetailResponse> loadDetailCourse(@retrofit2.http.Path(value = "courseId")
    int courseId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/spot/my")
    public abstract retrofit2.Call<com.example.fika_project.ui.main.mypage.myspot.MySpotResponse> loadMySpot();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/member/social")
    public abstract retrofit2.Call<com.example.fika_project.ui.login.KakaoResponse> signUp(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.fika_project.retrofit.User user);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/spot/detail/{spotId}")
    public abstract retrofit2.Call<com.example.fika_project.ui.main.mycourse.placeinfo.PlaceInfoResponse> placeInfo(@retrofit2.http.Path(value = "spotId")
    int spotId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/nav/mypage")
    public abstract retrofit2.Call<com.example.fika_project.ui.main.mypage.MypageResponse> Mypage();
}