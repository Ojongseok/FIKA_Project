package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.databinding.MycourseViewItemListBinding
import java.util.*
import kotlin.collections.ArrayList

// 리사이클러뷰 어댑터
class MyRecyclerViewAdapter(private val items : ArrayList<String>) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    // 뷰 레이아웃 (item_list.xml) 연결 후 뷰 홀더 만들어서 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder (
        MycourseViewItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    // 전달받은 위치의 아이템 연결
    override fun onBindViewHolder(holder: MyRecyclerViewAdapter.MyViewHolder, position: Int) = holder.bind(items[position])
    // 아이템 갯수 리턴
    override fun getItemCount() = items.size
    // -----------------데이터 조작함수 추가-----------------

    // position 위치의 데이터를 삭제 후 어댑터 갱신
    fun removeData(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    // 현재 선택된 데이터와 드래그한 위치에 있는 데이터를 교환
    fun swapData(fromPos: Int, toPos: Int) {
        Collections.swap(items, fromPos, toPos)
        notifyItemMoved(fromPos, toPos)
    }

    // 뷰 홀더 설정
    inner class MyViewHolder(private val binding : MycourseViewItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(title : String) {
            // 제목 달기
            binding.title = title
            binding.courseItemNumber.text = (layoutPosition+1).toString()

            // 삭제 텍스트뷰 클릭시 토스트 표시
            binding.tvRemove.setOnClickListener {
                removeData(this.layoutPosition)
                Toast.makeText(binding.root.context, "삭제했습니다.", Toast.LENGTH_SHORT).show()
                notifyDataSetChanged()
            }
        }
    }

}