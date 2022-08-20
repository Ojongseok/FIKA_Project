package com.example.fika_project.ui.main.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityDramaInfoBinding
import com.example.fika_project.databinding.ActivityFolderSelectBinding
import com.example.fika_project.ui.main.mycourse.course_edit.MyCourseViewActivity
import kotlinx.android.synthetic.main.folder_item.view.*

class FolderSelectActivity : AppCompatActivity() {
    private var _Binding: ActivityFolderSelectBinding? = null
    private val binding get() = _Binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityFolderSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.folderSelectGoCourseBtn.setOnClickListener {
            startActivity(Intent(this, MyCourseViewActivity::class.java))
        }
        binding.folderSelectStayBtn.setOnClickListener {
            onBackPressed()
        }
        binding.folderSelectRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = FolderSelectAdapter()
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_down_enter, R.anim.slide_down_exit)

    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}

class FolderSelectAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.folder_item,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        var list : ArrayList<String> = ArrayList()
        list.add("이태원 클라쓰 투어")
        list.add("사랑의 불시착 투어")
        list.add("알고있지만 투어")

        view.folder_name_tv.text = list[position]
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = 3
}