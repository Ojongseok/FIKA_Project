package com.example.fika_project

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.fika_project.config.XAccessTokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {
    companion object{
        const val X_ACCESS_TOKEN: String = "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJtZW1iZXJJZCI6MywibWVtYmVyRW1haWwiOiJ0ZXN0ZXJAdGVzdC5jb20iLCJpYXQiOjE2NjEyNDMyNjEsImV4cCI6MTY2MTg0ODA2MX0.3CLhVPdl4UmPJf5TTvQ5Z2mm_XGruXh7GL6aX4nCynI"

        const val TAG: String = "FIKA-Prj"

        const val API_URL: String = "http://ec2-15-165-255-15.ap-northeast-2.compute.amazonaws.com:9090";

        lateinit var prefs: SharedPreferences

        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        prefs = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)

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

        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}