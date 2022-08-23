package com.example.fika_project.ui.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentMyplaceBinding

class MyplaceFragment: Fragment() {
    private var _binding: FragmentMyplaceBinding? = null
    private val binding get() = _binding!!

    private var myplaceDatas = ArrayList<Myplace>();

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?)
    : View {
        _binding = FragmentMyplaceBinding.inflate(inflater, container, false)

        onClickListener()
        initView()
        initData()

        return binding.root
    }

    private fun onClickListener() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.myplaceBackIv.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
    }

    private fun initView() {
        binding.myplaceRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val myplaceRVAdapter = MyplaceRVAdapter(myplaceDatas)
        binding.myplaceRv.adapter = myplaceRVAdapter
    }


    private fun initData(){
        myplaceDatas.apply {
            add(Myplace(1, R.color.sub_blue, "우영우 코스","이상한 변호사 우영우"))
            add(Myplace(2, R.color.sub_yellow, "박새로이 코스","이태원클라스"))
            add(Myplace(3, R.color.main_blue, "우영우 코스","이상한 변호사 우영우"))
            add(Myplace(4, R.color.main_yellow, "박새로이 코스","이태원클라스"))
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}