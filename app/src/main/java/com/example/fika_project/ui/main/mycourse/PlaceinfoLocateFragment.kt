package com.example.fika_project.ui.main.mycourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.example.fika_project.databinding.FragmentPlaceinfoLocateBinding
import kotlinx.android.synthetic.main.fragment_placeinfo_locate.*

class PlaceinfoLocateFragment: Fragment() {
    private var _binding: FragmentPlaceinfoLocateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPlaceinfoLocateBinding.inflate(inflater, container, false)

        initView()

        return binding.root
    }

    private fun initView() {

//        binding.placeinfoLocateUpBtn.setOnClickListener {
//            binding.placeinfoLocateSv.post(Runnable {
//                binding.placeinfoLocateSv.fullScroll(ScrollView.FOCUS_UP)
//            }
//            )
//        }

        binding.placeinfoLocateUpBtn.setOnClickListener {
                binding.placeinfoLocateSv.fullScroll(ScrollView.FOCUS_UP)
        }
    }

        override fun onDestroy() {
            _binding = null
            super.onDestroy()
        }
    }