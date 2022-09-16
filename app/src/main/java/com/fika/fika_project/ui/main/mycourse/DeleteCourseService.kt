package com.fika.fika_project.ui.main.mycourse

import android.util.Log
import com.fika.fika_project.ApplicationClass
import com.fika.fika_project.retrofit.GroupName
import com.fika.fika_project.retrofit.RetrofitInterface
import com.fika.fika_project.ui.login.BasicResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteCourseService (val View: DeleteCourseView, val courseId : Int) {
    val retrofit = ApplicationClass.retrofit.create(RetrofitInterface::class.java)
    val load = retrofit.deleteCourse(courseId)
    fun tryDeleteCourse() {
        View.onLoading()
        load.enqueue(object : Callback<DeleteCourseResponse> {
            override fun onResponse(
                call: Call<DeleteCourseResponse>,
                response: Response<DeleteCourseResponse>
            ) {
                val resp = response.body()

                when (resp?.code) {
                    1021 -> {
                        View.onDeleteCourseSuccess(response.body() as DeleteCourseResponse)
                        Log.d("ADDGROUP", "성공.")
                    }
                }
            }

            override fun onFailure(call: Call<DeleteCourseResponse>, t: Throwable) {
                Log.d("MYCOURSE/API-ERROR", t.toString())
            }
        })
    }
}
