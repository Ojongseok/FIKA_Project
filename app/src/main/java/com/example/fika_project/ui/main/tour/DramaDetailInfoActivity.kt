package com.example.fika_project.ui.main.tour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.ActivityActorDetailSceneBinding
import com.example.fika_project.databinding.ActivityDramaDetailInfoBinding

class DramaDetailInfoActivity : AppCompatActivity() {
    private var _Binding: ActivityDramaDetailInfoBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityDramaDetailInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}