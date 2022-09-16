package com.fika.fika_project.ui.main.mypage

import androidx.fragment.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentMyholdcourseBinding
import com.fika.fika_project.ui.main.MainActivity
import com.fika.fika_project.ui.main.mypage.myspot.MySpotResponse
import com.fika.fika_project.ui.main.mypage.myspot.MySpotService
import com.fika.fika_project.ui.main.mypage.myspot.MySpotView
import com.fika.fika_project.ui.main.mypage.myspot.result
import kotlinx.android.synthetic.main.fragment_myholdcourse.view.*
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
            //추가했습니다!
            val mActivity = activity as MainActivity
            binding.myplaceHomeIv.setOnClickListener {
                mActivity.changeFragment(1)
            }
        }

    }

    override fun onExploreLoading() {
        binding.myscrapcourseEmptyPb.visibility = View.VISIBLE
    }

    override fun onExploreSuccess(response: MySpotResponse) {
        binding.myscrapcourseEmptyPb.visibility = View.GONE

        when(response.code) {
            1000 -> {
                if (response.result!!.size == 0) {
                    binding.myscrapcourseEmptyIv.visibility = View.VISIBLE
                } else {
                    response.let {
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

        if(itemCount == 0){
            view.myscrapcourse_empty_iv.visibility = View.VISIBLE
            view.myplace_rv.visibility = View.GONE

        }else{
            view.myscrapcourse_empty_iv.visibility = View.GONE
            view.myplace_rv.visibility = View.VISIBLE
        }

        Glide.with(context).load(mySpotList[position].spotImageUrl).into(view.item_myplace_iv)
        view.item_myplace_place_tv.text = mySpotList[position].spotTitle
        view.item_myplace_place_cate_tv.text = mySpotList[position].type
        view.item_myplace_place_where_tv2.text = mySpotList[position].shortAddress

    }


    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = mySpotList.size
}