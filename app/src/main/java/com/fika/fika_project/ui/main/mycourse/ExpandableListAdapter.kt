package com.fika.fika_project.ui.main.mycourse

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fika.fika_project.R
import kotlinx.android.synthetic.main.fragment_mycourse_list_child.view.*
import kotlinx.android.synthetic.main.fragment_mycourse_list_header.view.*


class ExpandableListAdapter(val context: Context, private val data: MutableList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder?>() {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        var view: View? = null
        val context = parent.context

        when (type) {
            HEADER -> {
                val inflaterHeader =
                    parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                view = inflaterHeader.inflate(R.layout.fragment_mycourse_list_header, parent, false)
                return ListHeaderViewHolder(view)
            }
            CHILD -> {
                val inflaterChild =
                    parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
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

                itemController1.cardLayout.setOnClickListener {
                    context.startActivity(Intent(context,VisitCompleteCourse::class.java))
                }
                itemController1.childToggleBtn.setOnClickListener {
                    context.startActivity(Intent(context,CourseInfoEditActivity::class.java))
                }

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position]!!.type
    }

    override fun getItemCount(): Int {
        return data.size
    }

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

        init {
            child_title = itemView!!.child_title
            btn = itemView!!.list_child_toggle_btn
        }
    }

    class Item {
        var type = 0
        var text: String? = null
        var invisibleChildren: MutableList<Item?>? = null

        constructor() {}
        constructor(type: Int, text: String?) {
            this.type = type
            this.text = text
        }
    }

    companion object {
        const val HEADER = 0
        const val CHILD = 1
    }
}
