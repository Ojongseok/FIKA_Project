package com.example.fika_project.ui.login

import android.util.Log
import com.example.fika_project.ApplicationClass
import com.example.fika_project.retrofit.RetrofitInterface
import com.example.fika_project.utils.spfManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService (val View : LoginView) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun tryKakaoLogin(token: String){
        retrofit.kakaoLogin(token).enqueue(object : Callback<KakaoResponse> {
            override fun onResponse(call: Call<KakaoResponse>, response: Response<KakaoResponse>) {
                var result: KakaoResponse? = response.body()
                val resp = response.body()

                Log.d("KAKAOLOGIN/token", token)

                Log.d("KAKAOLOGIN/API-RESPONSE", result.toString())

                when(resp?.code){
                    //성공
                    1000 -> {
                        View.onKakaoSuccess(response.body() as KakaoResponse)
                        Log.d("KAKAOLOGIN/1000", resp.message)

                        spfManager.setJwt(resp.result)
                        Log.d("KAKAOLOGIN-setJwt", resp.result)

                    }
                    //최초
                    1002 -> {
                        View.onKakaoSuccess(response.body() as KakaoResponse)
                        spfManager.setEmail(resp.result)
                        Log.d("KAKAOLOGIN/1002", spfManager.getEmail().toString())
                    }
                    4000 -> { Log.d("KAKAOLOGIN", "Access-Token이 존재하지 않는 경우") }
                    4001 -> { Log.d("KAKAOLOGIN", "유효하지 않은 AccessToken") }
                    else ->  {
                        Log.d("LOGIN", "로그인 실패 : 서버 오류")
                } }
            }

            override fun onFailure(call: Call<KakaoResponse>, t: Throwable) {
                Log.d("LOGIN", "로그인 실패 : 서버 오류")
            }
        })}
}