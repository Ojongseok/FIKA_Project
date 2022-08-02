package com.example.fika_project.ui.main.stamp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fika_project.databinding.FragmentStampBinding
import com.example.fika_project.ui.main.TestActivity

class StampFragment:Fragment() {
    private var _binding: FragmentStampBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStampBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button.setOnClickListener {
            startActivity(Intent(requireContext(),TestActivity::class.java))
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}