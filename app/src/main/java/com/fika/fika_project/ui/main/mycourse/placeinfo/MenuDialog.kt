package com.fika.fika_project.ui.main.mycourse.placeinfo

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.WindowManager
import androidx.core.content.ContextCompat.startActivity
import com.fika.fika_project.R
import kotlinx.android.synthetic.main.momey_dialog.*
import java.lang.Math.ceil

// 커스텀 다이어로그 편집
class MenuDialog(val context: Context, val name : String, val price : String,val money : String) {
    private val dialog = Dialog(context)

    fun showDialog() {
        dialog.setContentView(R.layout.momey_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()


        dialog.dialog_title.text = "현재시간 기준 엔화 환율\n[100￥당 : " + money + "원]"
        dialog.dialog_menuname_tv.text = name
        dialog.dialog_menuprice_tv.text = price + "원"
        Log.d("TTT",money)
        val kr_price = price.replace(",","").toInt()
        val jp_money = (ceil((kr_price / money.toDouble()) * 100)).toInt()
        dialog.japan_money_tv.text ="약 " + jp_money.toString()+"￥"
    }
}