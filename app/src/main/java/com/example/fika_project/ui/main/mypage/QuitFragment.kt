package com.example.fika_project.ui.main.mypage

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fika_project.databinding.FragmentQuitBinding

class QuitFragment : Fragment() {
    private var _binding: FragmentQuitBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentQuitBinding.inflate(inflater, container, false)

        onClickListener()

        return binding.root
    }

    private fun onClickListener(){
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.quitBackBtn.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }

        binding.quitBtn.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("탈퇴")
                .setMessage("FIKA는 여러분을 위해 새로운 드라마 장소를 계속 업데이트하고 있습니다.\n" +
                        "아쉽지만 그래도 탈퇴하시겠어요?")
                .setPositiveButton("돌아가기", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        Log.d("MyTag", "positive")
                    }
                })
                .setNegativeButton("탈퇴", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        Log.d("MyTag", "negative")
                    }
                })
                .create()
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}