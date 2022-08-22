package com.example.fika_project.ui.login
import android.app.Application
import android.util.Log
import android.widget.Toast
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.Auth
import com.example.fika_project.retrofit.AuthResponse
import com.example.fika_project.retrofit.RetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService (val View : LoginView) {
    val RetrofitInterface = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun tryKakaoLogin(){
        RetrofitInterface.kakaoLogin().enqueue(object : Callback<AuthResponse>{
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                var result: AuthResponse? = response.body()
                val resp = response.body()!!

                Log.d("KLOGINACT/API-RESPONSE", result.toString())

                when(resp.code){ //성공
                    1000 -> {
                        View.onLoginSuccess(response.body() as AuthResponse)
                        Log.d("Login", "성공.")
                    }
                    4000-> { //Access-Token이 존재하지 않는 경우
                    Log.d("Login", "존재하지 않는 아이디입니다.")
                    }
                    4001-> { //유효하지 않은 AccessToken
                    Log.d("Login", "비밀번호가 일치하지 않습니다")
                } else ->  {
                    Log.d("Login", "로그인 실패 : 서버 오류")
                } }}

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
            }
    })}
}