package com.example.fika_project.ui.login

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.Nickname
import com.example.fika_project.retrofit.RetrofitInterface
import com.example.fika_project.retrofit.User
import com.example.fika_project.utils.spfManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NicknameService(val View : NicknameView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun tryNicknameCheck(nickname: Nickname){
        retrofit.nicknameCheck(nickname).enqueue(object : Callback<AuthResponse> {
            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                var result: AuthResponse? = response.body()
                val resp = response.body()

                Log.d("NICKCHECK/API-RESPONSE", result.toString())

                when(resp?.code){
                    //성공
                    1000 -> {
                        View.onNicknameCheckSuccess(response.body() as AuthResponse)
                        Log.d("NICKCHECK", resp.message)
                    }
                    //최초
                    4020 -> { Log.d("NICKCHECK", "필수값이 포함되지 않은 경우") }
                    4024 -> { Log.d("NICKCHECK", "닉네임이 중복된 경우") }
                    4026 -> { Log.d("NICKCHECK", "닉네임 형식이 아닌경우") }
                    else ->  {
                        Log.d("NICKCHECK", "NICKCHECK 실패 : 서버 연결 오류")
                    } }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("NICKCHECK-FAIL", "NICKCHECK 실패 : 서버 오류")
            }
        })}

    fun trySignUp(user : User){
        retrofit.signUp(user).enqueue(object : Callback<KakaoResponse> {
            override fun onResponse(call: Call<KakaoResponse>, response: Response<KakaoResponse>) {
                var result: KakaoResponse? = response.body()
                val resp = response.body()

                Log.d("SIGNUP/API-RESPONSE", result.toString())

                when(resp?.code){
                    //성공
                    1000 -> {
                        spfManager.setJwt(resp.result)
                        Log.d("SIGNUP-setJwt", resp.result)

                        View.onSignUpSuccess(response.body() as KakaoResponse)
                        Log.d("SIGNUP", resp.message)
                    }
                    //최초
                    4020 -> { Log.d("SIGNUP", "필수값이 포함되지 않은 경우") }
                    else ->  {
                        Log.d("SIGNUP", "SIGNUP 실패 : 서버 연결 오류")
                    } }
            }

            override fun onFailure(call: Call<KakaoResponse>, t: Throwable) {
                Log.d("SIGNUP-FAIL", "SIGNUP 실패 : 서버 오류")
            }
        })}

}