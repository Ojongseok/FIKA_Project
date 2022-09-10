package com.fika.fika_project.ui.main.explore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityFolderSelectBinding
import com.fika.fika_project.ui.main.explore.folder.FolderResponse
import com.fika.fika_project.ui.main.explore.folder.FolderService
import com.fika.fika_project.ui.main.explore.folder.FolderView
import com.fika.fika_project.ui.main.explore.folder.result
import com.fika.fika_project.ui.main.mycourse.course_edit.MyCourseViewActivity
import kotlinx.android.synthetic.main.folder_item.view.*

class FolderSelectActivity : AppCompatActivity(),FolderView {
    private var _Binding: ActivityFolderSelectBinding? = null
    private val binding get() = _Binding!!
    var courseId = 0
    val service = FolderService(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityFolderSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        courseId = intent.getIntExtra("courseId",0)
        binding.folderSelectGoCourseBtn.setOnClickListener {
            val intent = Intent(this, MyCourseViewActivity::class.java)
            intent.putExtra("courseId",courseId)
            startActivity(intent)
        }
        binding.folderSelectStayBtn.setOnClickListener {
            onBackPressed()
        }

        service.tryloadFolder()

    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_down_enter, R.anim.slide_down_exit)

    }
    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }

    override fun onExploreSuccess(response: FolderResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    binding.folderSelectRecyclerview.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = FolderSelectAdapter(it.result!!,context)
                    }
                }
            }
        }

    }
    override fun onExploreFailure() {
    }
}

class FolderSelectAdapter(val folderList : ArrayList<result>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var clickList = Array(folderList.size) {false}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.folder_item,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        view.folder_name_tv.text = folderList[position].courseGroupName
        view.folder_name_tv.setOnClickListener {
            clickList[position] = true
            Log.d("TAG",clickList[position].toString())

        }
        if (clickList[position]) {
            view.folder_name_tv.setTextColor(ContextCompat.getColor(context,R.color.black))
        } else {
            view.folder_name_tv.setTextColor(ContextCompat.getColor(context,R.color.grey3))
        }

    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = folderList.size
}