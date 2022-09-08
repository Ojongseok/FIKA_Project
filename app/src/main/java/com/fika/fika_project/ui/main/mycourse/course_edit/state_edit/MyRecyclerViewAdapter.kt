package com.fika.fika_project.ui.main.mycourse.course_edit.state_edit

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.MycourseViewItemListBinding
import com.fika.fika_project.ui.main.mycourse.course_edit.state_save.spotList
import kotlinx.android.synthetic.main.mycourse_save_state_list.view.*
import kotlinx.android.synthetic.main.mycourse_view_item_list.view.*
import java.util.*
import kotlin.collections.ArrayList

// 리사이클러뷰 어댑터
class MyRecyclerViewAdapter(private val items : ArrayList<spotList>, val context: Context) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(),MyCourseEditState.returnItems {

    // 뷰 레이아웃 (item_list.xml) 연결 후 뷰 홀더 만들어서 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder (
        MycourseViewItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    // 전달받은 위치의 아이템 연결
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind(items)
    override fun getItems(): ArrayList<Long> {
        val list = ArrayList<Long>()
        for (i in 0 until items.size) {
            list.add(items[i].spotId!!.toLong())
        }
        return list
    }
    // 아이템 갯수 리턴
    override fun getItemCount() = items.size
    // -----------------데이터 조작함수 추가-----------------

    // position 위치의 데이터를 삭제 후 어댑터 갱신
    fun removeData(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount - position)
    }

    // 현재 선택된 데이터와 드래그한 위치에 있는 데이터를 교환
    fun swapData(fromPos: Int, toPos: Int) {
        Collections.swap(items, fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
    }

    // 뷰 홀더 설정
    inner class MyViewHolder(private val binding : MycourseViewItemListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(items : ArrayList<spotList>) {

            // 제목 달기
            binding.courseItemNumber.text = (layoutPosition+1).toString()
            binding.courseEditStateName.text = items[layoutPosition].spotTitle
            binding.courseEditStateSub.text = items[layoutPosition].shortAddress + "·" + items[layoutPosition].type
            if (items[layoutPosition].type.equals("cafe")) {
                binding.stateEditBar.setImageResource(R.drawable.course_edit_bar_yellow)
            } else if (items[layoutPosition].type.equals("playground")) {
                binding.stateEditBar.setImageResource(R.drawable.course_edit_bar_blue)
            } else {
                binding.stateEditBar.setImageResource(R.drawable.course_edit_bar_red)
            }
            Glide.with(context).load(items[layoutPosition].spotImageUrl).into(binding.itemListDramaImage)


            // 삭제 텍스트뷰 클릭시 토스트 표시
            binding.tvRemove.setOnClickListener {
                removeData(this.layoutPosition)
                Toast.makeText(binding.root.context, "삭제했습니다.", Toast.LENGTH_SHORT).show()
                notifyDataSetChanged()
            }
        }
    }

}