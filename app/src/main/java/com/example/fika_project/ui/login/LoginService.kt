package com.example.fika_project.ui.login

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import com.example.fika_project.utils.saveJwt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService (val View : LoginView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val token = ApplicationClass.X_ACCESS_TOKEN
    val loadhome = retrofit.loadHome(token)

    fun tryKakaoLogin(){
        retrofit.kakaoLogin().enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                var result: LoginResponse? = response.body()
                val resp = response.body()!!

                Log.d("LOGINACT/API-RESPONSE", result.toString())

                when(resp.code){ //성공
                    1000 -> {
                        View.onKakaoSuccess(response.body() as LoginResponse)
                        saveJwt(resp.result!!.toString())
                        Log.d("LOGIN", "성공.")
                    }
                    4000 -> { Log.d("LOGIN", "Access-Token이 존재하지 않는 경우") }
                    4001 -> { Log.d("LOGIN", "유효하지 않은 AccessToken") }
                    else ->  {
                    Log.d("LOGIN", "로그인 실패 : 서버 오류")
                } }}

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("LOGIN", "로그인 실패 : 서버 오류")
            }
        })}
}