package com.fika.fika_project.ui.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fika.fika_project.R
import com.fika.fika_project.databinding.DialogLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface BottomSheetClickListener {
    fun onButtomSheetClicked(type: String)
}

class LoginDialog : BottomSheetDialogFragment() {
    lateinit var binding : DialogLoginBinding
    lateinit var bottomSheetClickListener: BottomSheetClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DialogLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
          bottomSheetClickListener = context as BottomSheetClickListener
        } catch(e: Exception){
           Log.e("BottomDialog","onAttatch Error")
         }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClikckListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun initClikckListener() {
        binding.loginDialogEmail.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfX-j0oxVoXsTW5DPd-kVrex_ZLq7LTF8N3Idl_9pFAw-jZfg/viewform?usp=sf_link"))
            startActivity(intent)
        }
    }

}
