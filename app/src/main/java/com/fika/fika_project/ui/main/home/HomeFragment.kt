package com.fika.fika_project.ui.main.home

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.fika.fika_project.databinding.FragmentHomeBinding
import com.fika.fika_project.ui.main.home.search.SearchActivity
import com.fika.fika_project.ui.main.mycourse.placeinfo.PlaceinfoActivity

class HomeFragment : Fragment(), HomeView {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var fContext : Context
    val service = HomeService(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        service.tryLoadHome()
        setOnClickListener()
        return binding.root
    }

    fun setOnClickListener(){
        binding.homeSearchEt.setOnClickListener {
            val intent = Intent(context, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setMyCourseRVAdapter(courseList: ArrayList<myCourseList>){
        val myCourseRVAdapter = MyCourseRVAdapter(courseList,fContext)

        binding.homeMyCourseRv.layoutManager = LinearLayoutManager(fContext, LinearLayoutManager.HORIZONTAL, false)
        binding.homeMyCourseRv.adapter = myCourseRVAdapter
        binding.homeMyCourseRv.setHasFixedSize(false)

        myCourseRVAdapter.setMyItemClickListener(object  : MyCourseRVAdapter.MyItemClickListener{
            override fun onItemClick(course: myCourseList) {

            }
        })
    }

    private fun setDramaRankRVAdapter(dramaRankList: ArrayList<dramaList>){
        val dramaRankRVAdapter = DramaRankRVAdapter(dramaRankList,fContext)

        binding.homeDramaRankRv.layoutManager = LinearLayoutManager(fContext, LinearLayoutManager.HORIZONTAL, false)
        binding.homeDramaRankRv.adapter = dramaRankRVAdapter
        binding.homeDramaRankRv.setHasFixedSize(false)
    }

    private fun setCourseRVAdapter(scrapCourserankList: ArrayList<coursesSortBySaved>){
        val scrapCourserankRVAdapter = ScrapCourserankRVAdapter(scrapCourserankList,fContext)

        binding.homeScrapcourseRankRv.layoutManager = LinearLayoutManager(fContext, LinearLayoutManager.VERTICAL, false)
        binding.homeScrapcourseRankRv.adapter = scrapCourserankRVAdapter
        binding.homeDramaRankRv.setHasFixedSize(false)
    }

    private fun setPlaceRankRVAdapter(placeRankList: ArrayList<spotsSortBySaved>){
        val placeRankRVAdapter = PlaceRankRVAdapter(placeRankList,fContext)

        binding.homePlaceRankRv.layoutManager = LinearLayoutManager(fContext, LinearLayoutManager.HORIZONTAL, false)
        binding.homePlaceRankRv.adapter = placeRankRVAdapter
        binding.homePlaceRankRv.setHasFixedSize(false)
 }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onHomeLoading() {
        binding.homePb.visibility = View.VISIBLE
    }

    override fun onHomeSuccess(response: HomeResponse) {

        when(response.code) {
            1000 -> {
                binding.homePb.visibility = View.GONE

                response?.let { setMyCourseRVAdapter((it.result?.myCourseList!!)) }
                response?.let { setDramaRankRVAdapter(it.result?.dramaList!!) }
                response?.let { setCourseRVAdapter((it.result?.coursesSortBySaved!!)) }
                response?.let { setPlaceRankRVAdapter((it.result?.spotsSortBySaved!!)) }
            }
        }
    }

    override fun onHomeFailure(code: Int, message: String) {
        Toast.makeText(requireContext(),"통신 에러",Toast.LENGTH_SHORT).show()
    }
}

