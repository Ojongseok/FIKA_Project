package com.example.fika_project.ui.login

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fika_project.R
import com.example.fika_project.databinding.DialogLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

interface BottomSheetClickListener {
    fun onButtomSheetClicked(type: String)
}

class Signup01Dialog : BottomSheetDialogFragment() {
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
    }

}
