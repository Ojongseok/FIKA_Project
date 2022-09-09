package com.fika.fika_project.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fika.fika_project.databinding.FragmentNicknameBinding
import com.fika.fika_project.retrofit.Nickname
import com.fika.fika_project.retrofit.User
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.utils.spfManager

class NicknameFragment  : Fragment(), NicknameView {
    private var _binding: FragmentNicknameBinding? = null
    val service = NicknameService(this)

    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentNicknameBinding.inflate(inflater, container, false)

        initClickListener()

        return binding.root
    }

    private fun initClickListener(){
        val lActivity = activity as LoginActivity

        binding.nicknameBackBtn.setOnClickListener {
            lActivity.changeFragment(2)
        }
        binding.nicknameDoneTv.setOnClickListener {
            //4번 api 닉네임 중복 검사
            val inputNickname = binding.nicknameEt.getText().toString()
            Log.d("닉네임 input", inputNickname)

            val getNickname = Nickname(inputNickname)

            service.tryNicknameCheck(getNickname)
            //1000 이면 20번 api 회원가입 완료
       }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoading() {
//        TODO("Not yet implemented")
    }

    override fun onNicknameCheckSuccess(response: AuthResponse) {
        when(response?.code){
            //성공
            1000 -> {
                spfManager.setNickname(binding.nicknameEt.getText().toString())

                val nickname = spfManager.getNickname().toString()
                val email = spfManager.getEmail().toString()
                val getUser = User(nickname, email)

                service.trySignUp(getUser)
            }
            4020 ->  { Log.d("LOGIN/4020", "필수값이 포함되지 않은 경우") }
            4024 ->  { Log.d("LOGIN/4024", "닉네임이 중복된 경우") }
            4026 ->  { Log.d("LOGIN/4026", "닉네임 형식이 아닌경우") }
            else ->  { Log.d("LOGIN", "로그인 실패 : 오류") }
        }
    }

    override fun onSignUpSuccess(response: BasicResponse) {
        when(response.code){
            //성공
            1000 -> {
                spfManager.setJwt(response.result)
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
            else ->  { Log.d("LOGIN-FAIL", "회원가입 실패") }
        }
    }

}
