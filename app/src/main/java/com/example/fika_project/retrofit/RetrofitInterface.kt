package com.example.fika_project.retrofit

import com.example.fika_project.ui.main.explore.DramaInfoResponse
import com.example.fika_project.ui.main.explore.ExploreCourseResponse
import com.example.fika_project.ui.main.explore.course_detail.CourseDetailResponse
import com.example.fika_project.ui.main.explore.filter_drama.ExploreDramaResponse
import com.example.fika_project.ui.main.home.HomeResponse
import com.example.fika_project.ui.main.mypage.myspot.MySpotResponse
import com.example.fika_project.ui.login.AuthResponse
import com.example.fika_project.ui.main.hold_and_scrap.LocationHoldResponse
import com.example.fika_project.ui.login.KakaoResponse
import com.example.fika_project.ui.main.mycourse.placeinfo.PlaceInfoResponse
import com.example.fika_project.ui.main.mypage.MypageResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    //1. 카카오 로그인
    @POST("/oauth/login/kakao")
    fun kakaoLogin(
        @Header("Access-Token") token: String
    ): Call<KakaoResponse>

    //4. 닉네임 유효성 검사
    @POST("/member/valid/nickname")
    fun nicknameCheck(
        @Body nickname: Nickname
    ): Call<AuthResponse>

    //8. 메인 페이지 데이터 조회
    @GET("/nav/main")
    fun loadHome(): Call<HomeResponse>

    //10. 드라마 필터 조회
    @GET("/drama/{filter}")
    fun loadDramaFilter(
        @Path("filter") filter : String
    ) :Call<ExploreDramaResponse>

    //11. 코스 필터 조회
    @GET("/course/{filter}")
    fun loadCourseFilter(
        @Path("filter") filter : String
    ) :Call<ExploreCourseResponse>

    //12. 드라마 상세 조회
    @GET("/drama/{dramaId}")
    fun loadDramaInfoCourse(
        @Path("dramaId") dramaId : Int
    ) :Call<DramaInfoResponse>

    //18. 코스 상세 조회
   @GET("course/detail/{courseId}")
    fun loadDetailCourse(
        @Path("courseId") courseId : Int
    ) :Call<CourseDetailResponse>

    // 19. 내가 담은 장소 조회
    @GET("/spot/my")
    fun loadMySpot () : Call<MySpotResponse>

    // 15. 장소 담기
    @POST("/spot/scrap/{spotId}")
    fun postLocationHold(
        @Header("Access-Token") token: String,
        @Path("spotId") spotId : Int
    ): Call<LocationHoldResponse>

    //20. 소셜 인증 후 회원가입
    @POST("/member/social")
    fun signUp(
        @Body user: User
    ): Call<KakaoResponse>

    //20. 장소 상세 조회
    @GET("/spot/detail/{spotId}")
    fun placeInfo(
        @Path("spotId") spotId : Int
    ): Call<PlaceInfoResponse>

    // 25. 마이페이지 조회
    @GET("/nav/mypage")
    fun Mypage() : Call<MypageResponse>
}