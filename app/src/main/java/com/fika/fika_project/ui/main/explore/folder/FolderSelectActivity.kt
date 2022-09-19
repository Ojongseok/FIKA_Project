package com.fika.fika_project.ui.main.explore

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fika.fika_project.R
import com.fika.fika_project.databinding.ActivityFolderSelectBinding
import com.fika.fika_project.retrofit.AddCourseDTO
import com.fika.fika_project.ui.main.explore.folder.*
import com.fika.fika_project.ui.main.mycourse.course_edit.MyCourseViewActivity
import kotlinx.android.synthetic.main.folder_item.view.*
import okhttp3.internal.notify

class FolderSelectActivity : AppCompatActivity(),FolderView,CreateCourseView {
    private var _Binding: ActivityFolderSelectBinding? = null
    private val binding get() = _Binding!!
    var courseId = 0
    val service = FolderService(this)
    var selectPosition = -1
    var groupId = 0
    lateinit var addCourseDTO : AddCourseDTO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityFolderSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        courseId = intent.getIntExtra("courseId",0)
        addCourseDTO = intent.getSerializableExtra("addCourseDTO") as AddCourseDTO
        binding.folderSelectGoCourseBtn.setOnClickListener {
            if (selectPosition ==-1) {
                Toast.makeText(this,"グループを選択してください。",Toast.LENGTH_SHORT).show()
            } else {
                addCourseDTO.courseGroupId = groupId
                val service = CreateCourseService(this,addCourseDTO)
                service.tryCreateCourse()
            }
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

    override fun onExploreLoading() {
        binding.folderPr.visibility = View.VISIBLE
    }

    override fun onExploreSuccess(response: CreateCourseResponse) {
        when (response.code) {
            1000 -> {
                binding.folderPr.visibility = View.GONE
                response.let {
                    val intent = Intent(this, MyCourseViewActivity::class.java)
                    intent.putExtra("courseId", it.result)
                    intent.putExtra("addCourseDTO",addCourseDTO)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    override fun onExploreFailure() {
    }
    inner class FolderSelectAdapter(val folderList : ArrayList<result>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.folder_item,parent,false)

            return CustomViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val view = (holder as CustomViewHolder).itemView
            view.folder_name_tv.text = folderList[position].courseGroupName
            if (selectPosition ==position) {
                view.folder_name_tv.setTextColor(ContextCompat.getColor(context,R.color.black))
            } else {
                view.folder_name_tv.setTextColor(ContextCompat.getColor(context,R.color.grey3))
            }
            view.folder_name_tv.setOnClickListener {
                selectPosition = position
                groupId = folderList[position].courseGroupId!!
                binding.folderSelectGoCourseBtn.isClickable = true
                notifyDataSetChanged()
            }
        }
        inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
        override fun getItemCount() = folderList.size
    }
}
