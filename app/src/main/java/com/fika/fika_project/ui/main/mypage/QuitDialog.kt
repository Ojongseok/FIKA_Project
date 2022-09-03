package com.fika.fika_project.ui.main.mypage

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.fika.fika_project.databinding.DialogQuitBinding

class QuitDialog(context: Context, private val okCallback: (String) -> Unit, ) : Dialog(context) {
    private lateinit var binding: DialogQuitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogQuitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        setCancelable(true)

        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.dialogQuitBackBtn.setOnClickListener {
            setCancelable(true)
        }

        binding.dialogQuitQuitBtn.setOnClickListener {
            //탈퇴 실행
        }
    }
}