package com.fika.fika_project.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentNicknameBinding
import com.fika.fika_project.databinding.FragmentTesterloginBinding
import com.fika.fika_project.retrofit.Nickname
import com.fika.fika_project.retrofit.User
import com.fika.fika_project.retrofit.testerCode
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.utils.spfManager
import com.google.android.material.snackbar.Snackbar

class TesterloginFragment  : Fragment(), LoginView {
    private var _binding: FragmentTesterloginBinding? = null
    val service = LoginService(this)

    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTesterloginBinding.inflate(inflater, container, false)

        initClickListener()

        return binding.root
    }

    private fun initClickListener(){
        val lActivity = activity as LoginActivity

        binding.testerLoginBackBtn.setOnClickListener {
            lActivity.changeFragment(1)
        }
        binding.testerLoginDoneTv.setOnClickListener {
            //테스터 로그인 (rf2amgpNuA)
            val getCode = testerCode(binding.testerLoginEt.getText().toString())
            service.tryTesterLogin(getCode)
        }

        binding.testerLoginEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                //텍스트를 입력 후

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //텍스트 입력 전
            }
            @SuppressLint("ResourceAsColor")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //텍스트 입력 중
                if(binding.testerLoginEt.length() < 4) { // 패스워드의 길이가 4미만이면
                    binding.testerLoginDoneTv.isEnabled = false // 버튼 비활성화
                    binding.testerLoginDoneTv.setBackgroundColor(R.color.grey3)
                } else {
                    binding.testerLoginDoneTv.isEnabled = true // 버튼 활성화
                    binding.testerLoginDoneTv.setBackgroundColor(R.color.main_blue)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoading() {
        binding.testerLoginPb.visibility = View.VISIBLE
    }

    override fun onKakaoSuccess(response: BasicResponse) {
//        없는 함수
    }

    override fun onTesterSuccess(response: BasicResponse) {
        binding.testerLoginPb.visibility = View.GONE

        when(response.code){
          1000 -> {
              binding.testerLoginWarningTv.visibility = View.GONE
              Snackbar.make(requireView(), "TESTER LOGIN", Snackbar.LENGTH_SHORT).setAction("Action", null).show()

              val intent = Intent(activity, MainActivity::class.java)
              intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
              startActivity(intent)
          }
          else -> {
              binding.testerLoginWarningTv.visibility = View.VISIBLE
          }
        }
    }

    override fun onGoogleSuccess(response: BasicResponse) {
//        없는 함수
    }
}
