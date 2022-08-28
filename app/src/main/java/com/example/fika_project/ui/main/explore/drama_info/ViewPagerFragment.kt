package com.example.fika_project.ui.main.explore.drama_info

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.fika_project.R
import com.example.fika_project.ui.main.explore.spotDataList
import kotlinx.android.synthetic.main.fragment_view_pager.*
import kotlinx.android.synthetic.main.item_view.*
import kotlinx.android.synthetic.main.item_view.view.*
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class ViewPagerFragment(val mapView: MapView) : Fragment() {
    lateinit var spotlist: ArrayList<spotDataList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        spotlist = arguments?.getSerializable("spotlist") as ArrayList<spotDataList>
        val position = arguments?.getString("position")
        Log.d("TAG",spotlist.size.toString())
        val listAdapter = PagerRecyclerAdapter(spotlist,requireContext())

        // Adapter를 생성하면서 넘길 색상이 담긴 ArrayList<Int> 생성

        // RecyclerView.Adapter<ViewHolder>()
        viewPager.adapter = listAdapter
        // ViewPager의 Paging 방향은 Horizontal
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        setOnClickEvent(listAdapter)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            // Paging 완료되면 호출
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator_tv.text = (position+1).toString() + " / " + spotlist.size.toString()
            }
        })
    }
    private fun setOnClickEvent(listAdapter: PagerRecyclerAdapter) {
        // Adapter에 itemClickListener 등록
        listAdapter.setItemClickListener(object: PagerRecyclerAdapter.OnItemClickListener {
            override fun onClick(view: View, position: Int) {
                super.onClick(view, position) // 미리 정의해둔 onClick 호출

                mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(spotlist[position].mapY!!, spotlist[position].mapX!!),true)

            }
        })
    }

}