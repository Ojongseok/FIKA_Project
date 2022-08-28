package com.example.fika_project.ui.main.mycourse

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import com.example.fika_project.R
import kotlinx.android.synthetic.main.review_dialog.*

// 커스텀 다이어로그 편집
class ReviewDialog(val context: Context) {
    private val dialog = Dialog(context)

    fun showDialog() {
        dialog.setContentView(R.layout.review_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

        dialog.sejong_login_dialog_no.setOnClickListener {
            dialog.dismiss()
        }
        dialog.sejong_login_dialog_yes.setOnClickListener {
            dialog.dismiss()
            context.startActivity(Intent(context,ReviewWriteActivity::class.java))
        }
    }
}