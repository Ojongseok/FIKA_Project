package com.example.fika_project

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.fika_project.config.XAccessTokenInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {
    companion object{
        const val X_ACCESS_TOKEN: String = "X-ACCESS-TOKEN"         // JWT Token Key
        const val TAG: String = "FIKA-Prj"

        const val API_URL: String = "";

        lateinit var prefs: SharedPreferences

        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        prefs = applicationContext.getSharedPreferences(TAG, Context.MODE_PRIVATE)

        initRetrofitInstance()
    }

    private fun initRetrofitInstance(){
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