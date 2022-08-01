package com.example.fika_project.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityMainBinding
import com.example.fika_project.ui.main.home.HomeFragment
import com.example.fika_project.ui.main.mypage.MypageFragment
import com.example.fika_project.ui.main.stamp.StampFragment
import com.example.fika_project.ui.main.tour.TourFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()
    }

    private fun initNavigation() {
        supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment())
            .commitAllowingStateLoss()

        binding.btmNavi.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.btm_nav_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.btm_nav_tour -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, TourFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.btm_nav_stamp -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, StampFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.btm_nav_mypage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MypageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

            }
            false
        }
    }

}