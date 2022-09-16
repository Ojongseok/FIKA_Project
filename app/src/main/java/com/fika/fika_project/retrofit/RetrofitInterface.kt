package com.fika.fika_project.retrofit

import com.fika.fika_project.ui.main.explore.DramaInfoResponse
import com.fika.fika_project.ui.main.explore.ExploreCourseResponse
import com.fika.fika_project.ui.main.explore.course_detail.CourseDetailResponse
import com.fika.fika_project.ui.main.explore.filter_drama.ExploreDramaResponse
import com.fika.fika_project.ui.main.home.HomeResponse
import com.fika.fika_project.ui.main.mypage.myspot.MySpotResponse
import com.fika.fika_project.ui.login.AuthResponse
import com.fika.fika_project.ui.login.BasicResponse
import com.fika.fika_project.ui.main.explore.AddLocationResponse
import com.fika.fika_project.ui.main.explore.folder.FolderResponse
import com.fika.fika_project.ui.main.hold_and_scrap.LocationHoldResponse
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceInfoResponse
import com.fika.fika_project.ui.main.mypage.MyScrapResponse
import com.fika.fika_project.ui.main.mypage.MypageResponse
import com.fika.fika_project.ui.main.hold_and_scrap.LocationScrapResponse
import com.fika.fika_project.ui.main.mycourse.MyCourseResponse
import com.fika.fika_project.ui.main.mycourse.course_edit.state_edit.CourseEditResponse
import com.fika.fika_project.ui.main.mycourse.course_edit.state_save.CourseViewResponse
import com.fika.fika_project.ui.main.mycourse.placeinfo.ReportResponse
import com.fika.fika_project.ui.main.mycourse.visit_course.VisitCourseResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    //1. 카카오 로그인
    @POST("/oauth/login/kakao")
    fun kakaoLogin(
        @Header("Access-Token") token: String
    ): Call<BasicResponse>

    //37. 구글 로그인
    @POST("/oauth/login/google")
    fun googleLogin(
        @Body googleEmail: GoogleEmail
    ): Call<BasicResponse>

    //4. 닉네임 유효성 검사
    @POST("/member/valid/nickname")
    fun nicknameCheck(
        @Body nickname: Nickname
    ): Call<AuthResponse>

    //7. 단일 내 코스 조회
    @GET("/course/{courseId}")
    fun loadCourseView(
        @Path("courseId") courseId : Int
    ) :Call<CourseViewResponse>

    //32. 코스 보기(리뷰 작성 포함)
    @GET("/course/{courseId}/reviews")
    fun loadVisitCourse(
        @Path("courseId") courseId : Int
    ) :Call<VisitCourseResponse>

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

    // 22. 내가 담은 장소 조회
    @GET("/spot/my/scrap")
    fun loadMySpot (
    ) : Call<MySpotResponse>

    // 14. 코스 스크랩
    @POST("/course/scrap/{courseId}")
    fun postLocationScrap(
        @Path("courseId") courseId : Int
    ): Call<LocationScrapResponse>

    // 15. 장소 담기
    @POST("/spot/scrap/{spotId}")
    fun postLocationHold(
        @Path("spotId") spotId : Int
    ): Call<LocationHoldResponse>

    //17. 코스에 장소 추가
    @PATCH("/course/{courseId}/spots")
    fun loadAddLocation(
        @Path("courseId") courseId : Int,
        @Body addLocation : AddLocationDTO?
    ) :Call<AddLocationResponse>

    //17. 코스 편집
    @PATCH("/course/edit/{courseId}")
    fun loadCourseEdit(
        @Path("courseId") courseId : Int,
        @Body courseEditList : CourseEditDTO
    ) :Call<CourseEditResponse>

    //20. 소셜 인증 후 회원가입
    @POST("/member/social")
    fun signUp(
        @Body user: User
    ): Call<BasicResponse>

    //20. 장소 상세 조회
    @GET("/spot/detail/{spotId}")
    fun placeInfo(
        @Path("spotId") spotId : Int
    ): Call<PlaceInfoResponse>

    // 24. 리뷰 신고
    @POST("/review/report")
    fun ReviewReport(@Body reviewReport: ReviewReport) : Call<ReportResponse>

    // 25. 마이페이지 조회
    @GET("/nav/mypage")
    fun Mypage() : Call<MypageResponse>

    // 25. 마이페이지 조회
    @GET("/course/my/scrap")
    fun MyScrap() : Call<MyScrapResponse>

    // 27. 그룹 선택
    @GET("/group/my")
    fun loadFolder() : Call<FolderResponse>

    // 29. 그룹 생성
    @POST("/group")
    fun AddGroup(@Body groupName: GroupName) : Call<BasicResponse>

    // 30. 내 코스 보기
    @GET("/course/my")
    fun MyCourse() : Call<MyCourseResponse>

    // 31. 테스터 로그인
    @POST("/member/demo/tester")
    fun TesterLogin(@Body testerCode:testerCode) : Call<BasicResponse>

    // 33. 리뷰 편집
    @PUT("/review/{reviewId}")
    fun editReview(
        @Path("reviewId") reviewId : Int
    )
}