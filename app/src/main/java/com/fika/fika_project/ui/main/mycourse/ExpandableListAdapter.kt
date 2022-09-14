package com.fika.fika_project.ui.main.mycourse

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.ui.main.mycourse.course_edit.MyCourseViewActivity
import com.fika.fika_project.ui.main.mycourse.visit_course.VisitCompleteCourse
import kotlinx.android.synthetic.main.fragment_mycourse_list_child.view.*
import kotlinx.android.synthetic.main.fragment_mycourse_list_header.view.*


class ExpandableListAdapter(val context: Context, private val data: MutableList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        var view: View? = null
        val context = parent.context

        when (type) {
            HEADER -> {
                val inflaterHeader = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflaterHeader.inflate(R.layout.fragment_mycourse_list_header, parent, false)
                return ListHeaderViewHolder(view)
            }
            CHILD -> {
                val inflaterChild = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflaterChild.inflate(R.layout.fragment_mycourse_list_child, parent, false)
                return ListChildViewHolder(view)
            }
        }
        return ListChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        when (item!!.type) {
            HEADER -> {
                val itemController = holder as ListHeaderViewHolder?
                itemController!!.refferalItem = item
                itemController.header_title.text = item.text
                if (item.invisibleChildren == null) {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.stroke_up)
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.stroke_down)
                }
                itemController.btn_expand_toggle.setOnClickListener {
                    if (item.invisibleChildren == null) {
                        item.invisibleChildren = ArrayList()
                        var count = 0
                        val pos = data.indexOf(itemController.refferalItem)
                        while (data.size > pos + 1 && data[pos + 1]!!.type == CHILD) {
                            (item.invisibleChildren as ArrayList<Item?>).add(data.removeAt(pos + 1))
                            count++
                        }
                        notifyItemRangeRemoved(pos + 1, count)
                        itemController.btn_expand_toggle.setImageResource(R.drawable.stroke_down)
                    } else {
                        val pos = data.indexOf(itemController.refferalItem)
                        var index = pos + 1
                        for (i in item.invisibleChildren!!) {
                            data.add(index, i!!)
                            index++
                        }
                        notifyItemRangeInserted(pos + 1, index - pos - 1)
                        itemController.btn_expand_toggle.setImageResource(R.drawable.stroke_up)
                        item.invisibleChildren = null
                    }
                }
            }
            CHILD -> {
                val itemController1 = holder as ListChildViewHolder?
                itemController1!!.refferalItem = item
                itemController1.child_title.text = item.text
                itemController1.dramatitle.text = item.dramaTitle
                itemController1.address.text = item.address
                itemController1.spotinfo.text = item.spotList.toString()
                Glide.with(context).load(item.imageUrl).into(itemController1.imageurl)
                itemController1.cardLayout.setOnClickListener {
                    val intent = Intent(context,MyCourseViewActivity::class.java)
                    intent.putExtra("courseId",item.courseId)
                    context.startActivity(intent)
                }
                itemController1.childToggleBtn.setOnClickListener {
                    val menuList =arrayOf("리뷰 작성","그룹 이동","코스 정보 편집","코스 삭제")
                    val dialog = AlertDialog.Builder(context,android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar)
                    dialog.setTitle("선택").setItems(menuList, DialogInterface.OnClickListener { dialogInterface, i ->
                        when(i) {
                            0 -> {
                                val intent = Intent(context, VisitCompleteCourse::class.java)
                                intent.putExtra("courseId",item.courseId)
                                context.startActivity(intent)
                            }
                            1 -> {

                            }
                            2 -> {
                                context.startActivity(Intent(context,CourseInfoEditActivity::class.java))
                            }
                            3 -> {
                                Toast.makeText(context,menuList[i],Toast.LENGTH_SHORT).show()
                            }
                        }

                    })
                    dialog.show()
                }

            }
        }
    }
    override fun getItemViewType(position: Int) =data[position]!!.type
    override fun getItemCount() = data.size

    private class ListHeaderViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var header_title: TextView
        var btn_expand_toggle: ImageView
        var refferalItem: Item? = null

        init {
            header_title = itemView!!.list_header_title
            btn_expand_toggle = itemView.list_header_expand_btn
        }
    }
    private class ListChildViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var child_title: TextView
        var btn: ImageView
        var refferalItem: Item? = null
        var cardLayout = itemView!!.mycourse_child_layout
        var childToggleBtn = itemView!!.list_child_toggle_btn
        var dramatitle = itemView!!.item_home_coursescrap_drama_title_tv
        var address = itemView!!.item_home_coursescrap_where_tv
        var imageurl = itemView!!.item_home_scrapcourse_iv
        var spotinfo = itemView!!.item_home_coursescrap_info_tv

        init {
            child_title = itemView!!.child_title
            btn = itemView!!.list_child_toggle_btn
        }
    }

    class Item {
        var type = 0
        var text: String? = null
        var dramaTitle:String? = null
        var address:String? = null
        var imageUrl:String? = null
        var invisibleChildren: MutableList<Item?>? = null
        var courseId:Int? =0
        var spotList:List<String>? = null

        constructor(type: Int,text: String?) {
            this.type = type
            this.text = text
        }
        constructor(type: Int, text: String?,dramaTitle:String?,address: String?,imageUrl:String?,courseId:Int?,spotList:List<String>?) {
            this.type = type
            this.text = text
            this.address = address
            this.imageUrl = imageUrl
            this.dramaTitle = dramaTitle
            this.courseId = courseId
            this.spotList = spotList
        }
    }

    companion object {
        const val HEADER = 0
        const val CHILD = 1
    }
}