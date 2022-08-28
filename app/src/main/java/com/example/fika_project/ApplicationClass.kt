package com.example.fika_project

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.fika_project.config.XAccessTokenInterceptor
import com.kakao.auth.BuildConfig
import com.kakao.sdk.common.KakaoSdk
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {
    companion object{
        const val X_ACCESS_TOKEN: String = "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJtZW1iZXJJZCI6MiwibWVtYmVyRW1haWwiOiJ5dW55MGowQG5hdmVyLmNvbSIsImlhdCI6MTY2MTcxNDI1NSwiZXhwIjoxNjYyMzE5MDU1fQ.OZYejBOL36jRTNyTc07iGHPFF2EpbkWdW7KLA2eIzag"

        const val TAG: String = "FIKA-Prj"
        const val API_URL: String = "http://ec2-15-165-255-15.ap-northeast-2.compute.amazonaws.com:9090"

        lateinit var prefs: SharedPreferences
        lateinit var retrofit: Retrofit

        var appContext : Context? = null

    }

    override fun onCreate() {
        super.onCreate()
        prefs = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)

        appContext = this
        KakaoSdk.init(this,getString(R.string.kakao_app_key))

        initRetrofitInstance()
    }

    private fun initRetrofitInstance(){
        // Set Log Level of OkHttp
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        // Set Log Level of OkHttp
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .addInterceptor(httpLoggingInterceptor) // API Response 로그 작성
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
}