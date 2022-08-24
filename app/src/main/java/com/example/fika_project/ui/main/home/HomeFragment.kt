package com.example.fika_project.ui.main.home

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), HomeView {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val service = HomeService(this)

    private var courseDatas = ArrayList<Course>();
    private var placeRankData = ArrayList<PlaceRank>();

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initView()
        initData()

        service.tryLoadHome()

        return binding.root
    }

    private fun initView() {
        binding.homeCourseMakingRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val courseRVAdaper = CourseMakingRVAdapter(courseDatas)
        binding.homeCourseMakingRv.adapter = courseRVAdaper


        binding.homePlaceRankRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val placeRankRVAdapter = PlaceRankRVAdapter(placeRankData)
        binding.homePlaceRankRv.adapter = placeRankRVAdapter

    }

    private fun setDramaRankRVAdapter(dramaRankList: ArrayList<dramaList>){
        val dramaRankRVAdapter = DramaRankRVAdapter(dramaRankList,requireContext())

        binding.homeDramaRankRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.homeDramaRankRv.adapter = dramaRankRVAdapter
        binding.homeDramaRankRv.setHasFixedSize(false)

        dramaRankRVAdapter.setMyItemClickListener(object  : DramaRankRVAdapter.MyItemClickListener{
            override fun onItemClick(dramaRank: dramaList) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun setCourseRVAdapter(scrapCourserankList: ArrayList<coursesSortBySaved>){
        val scrapCourserankRVAdapter = ScrapCourserankRVAdapter(scrapCourserankList,requireContext())

        binding.homeScrapcourseRankRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.homeScrapcourseRankRv.adapter = scrapCourserankRVAdapter
        binding.homeDramaRankRv.setHasFixedSize(false)

        scrapCourserankRVAdapter.setMyItemClickListener(object  : ScrapCourserankRVAdapter.MyItemClickListener{
            override fun onItemClick(scrapCourserank: coursesSortBySaved) {
                TODO("Not yet implemented")
            }

        })
    }


    private fun initData(){
        courseDatas.apply {
            add(Course(1, R.color.sub_blue, "우영우 코스","이상한 변호사 우영우","법원"))
            add(Course(2, R.color.sub_yellow, "박새로이 코스","이태원클라스","단밤포차"))
            add(Course(3, R.color.main_blue, "우영우 코스","이상한 변호사 우영우","법원"))
            add(Course(4, R.color.main_yellow, "박새로이 코스","이태원클라스","단밤포차"))
        }

        placeRankData.apply {
            add(PlaceRank(1, R.color.sub_blue, "우영우"))
            add(PlaceRank(2, R.color.main_blue, "우영우우우"))
            add(PlaceRank(3, R.color.sub_yellow, "우영우우우"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onHomeLoading() {
//        TODO("Not yet implemented")
    }

    override fun onHomeSuccess(response: HomeResponse) {
        when(response.code){
            1000 -> {
                response.let {
                    response?.let { setDramaRankRVAdapter((it.result?.dramaList!!)) }
                    response?.let { setCourseRVAdapter((it.result?.coursesSortBySaved!!)) }
                }
            }
        }
    }

    override fun onHomeFailure(code: Int, message: String) {
//        TODO("Not yet implemented")
    }
}