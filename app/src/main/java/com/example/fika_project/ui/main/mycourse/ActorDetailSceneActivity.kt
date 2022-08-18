package com.example.fika_project.ui.main.mycourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.ActivityActorDetailSceneBinding

class ActorDetailSceneActivity : AppCompatActivity() {
    private var _Binding: ActivityActorDetailSceneBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityActorDetailSceneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailSceneListRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.detailSceneListRecyclerview.adapter = DetailSceneListAdapter(this)
    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}