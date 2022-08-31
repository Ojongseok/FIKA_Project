package com.example.fika_project.ui.main.mypage

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentMyholdcourseBinding
import com.example.fika_project.ui.main.MainActivity
import com.example.fika_project.ui.main.mypage.myspot.MySpotResponse
import com.example.fika_project.ui.main.mypage.myspot.MySpotService
import com.example.fika_project.ui.main.mypage.myspot.MySpotView
import com.example.fika_project.ui.main.mypage.myspot.result
import kotlinx.android.synthetic.main.item_myplace.view.*

class MyholdcourseFragment : Fragment(),MySpotView {
    private var _binding: FragmentMyholdcourseBinding? = null
    private val binding get() = _binding!!
    val service = MySpotService(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMyholdcourseBinding.inflate(inflater, container, false)

        service.tryloadMySpot()

        onClickListener()


        return binding.root
    }


    private fun onClickListener() {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager

        binding.myplaceBackIv.setOnClickListener {
            fragmentManager.beginTransaction().remove(this).commit()
            fragmentManager.popBackStack()
        }
        binding.myplaceHomeIv.setOnClickListener {
            // 홈버튼 누르면 홈으로 가도록 어떻게 만들죠,,?
        }

    }

    override fun onExploreLoading() {
    }
    override fun onExploreSuccess(response: MySpotResponse) {
        when(response.code) {
            1000 -> {
                if (response.result!!.size == 0) {
                    binding.myscrapcourseEmptyIv.visibility = View.VISIBLE
                } else {
                    response?.let {
                        binding.myplaceRv.layoutManager = LinearLayoutManager(requireContext())
                        binding.myplaceRv.adapter = MySpotAdapter(it.result!!, requireContext())
                        binding.myscrapcourseEmptyIv.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }
    override fun onExploreFailure(code: Int, message: String) {
    }
}
class MySpotAdapter(val mySpotList: ArrayList<result>,val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_myplace_2,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        Glide.with(context).load(mySpotList[position].spotImageUrl).into(view.item_myplace_iv)
        view.item_myplace_place_tv.text = mySpotList[position].spotTitle
        view.item_myplace_place_cate_tv.text = mySpotList[position].type
        view.item_myplace_place_where_tv2.text = mySpotList[position].shortAddress

    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = mySpotList.size
}