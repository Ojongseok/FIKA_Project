package com.fika.fika_project.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentAgree01Binding

class Agree01Fragment  : Fragment() {
    private var _binding: FragmentAgree01Binding? = null
    private val binding get() = _binding!!

    private var isChecked: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAgree01Binding.inflate(inflater, container, false)

        initClickListener()

        return binding.root
    }

    private fun initClickListener(){
        val lActivity = activity as LoginActivity

        binding.agree01BackBtn.setOnClickListener{
            lActivity.changeFragment(1)
        }
        binding.agree01More03.setOnClickListener {
            lActivity.changeFragment(3)
        }
        binding.agree01More04.setOnClickListener {
            lActivity.changeFragment(4)
        }
        binding.agree01CountinueBtn.setOnClickListener {
            lActivity.changeFragment(5)
        }

        binding.agree01Cb01.setOnClickListener{
            isChecked = !isChecked

            if(isChecked){
                binding.agree01Cb01.setImageResource(R.drawable.round_checkbox_off)
            }else{
                binding.agree01Cb01.setImageResource(R.drawable.round_checkbox_on)
                binding.agree01Cb02.setImageResource(R.drawable.round_checkbox_on)
                binding.agree01Cb03.setImageResource(R.drawable.round_checkbox_on)
                binding.agree01Cb04.setImageResource(R.drawable.round_checkbox_on)
                binding.agree01Cb05.setImageResource(R.drawable.round_checkbox_on)
            }
        }

        binding.agree01Cb02.setOnClickListener{
            isChecked = !isChecked

            if(isChecked){
                binding.agree01Cb02.setImageResource(R.drawable.round_checkbox_off)
            }else{
                binding.agree01Cb02.setImageResource(R.drawable.round_checkbox_on)
            }
        }

        binding.agree01Cb03.setOnClickListener{
            isChecked = !isChecked

            if(isChecked){
                binding.agree01Cb03.setImageResource(R.drawable.round_checkbox_off)
            }else{
                binding.agree01Cb03.setImageResource(R.drawable.round_checkbox_on)
            }
        }

        binding.agree01Cb04.setOnClickListener{
            isChecked = !isChecked

            if(isChecked){
                binding.agree01Cb04.setImageResource(R.drawable.round_checkbox_off)
            }else{
                binding.agree01Cb04.setImageResource(R.drawable.round_checkbox_on)
            }
        }

        binding.agree01Cb05.setOnClickListener{
            isChecked = !isChecked

            if(isChecked){
                binding.agree01Cb05.setImageResource(R.drawable.round_checkbox_off)
            }else{
                binding.agree01Cb05.setImageResource(R.drawable.round_checkbox_on)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}