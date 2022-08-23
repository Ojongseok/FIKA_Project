package com.example.fika_project.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityMainBinding
import com.example.fika_project.ui.main.home.HomeFragment
import com.example.fika_project.ui.main.explore.ExploreFragment
import com.example.fika_project.ui.main.mycourse.review.AllReviewFragment
import com.example.fika_project.ui.main.mycourse.MyCourseFragment
import com.example.fika_project.ui.main.mypage.MypageFragment
import com.example.fika_project.ui.main.mypage.QuitFragment

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
                        .replace(R.id.main_frm, MyCourseFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.btm_nav_stamp -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ExploreFragment())
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


    fun changeFragment(index: Int){
        when (index) {
            1 -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            2 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeinfo_locate_frm, AllReviewFragment())
                    .commitAllowingStateLoss()
            }
        }
    }

}