package com.example.fika_project.ui.main.home

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fika_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), HomeView {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val service = HomeService(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        service.tryLoadHome()

        return binding.root
    }

    private fun setMyCourseRVAdapter(courseList: ArrayList<myCourseList>){
        val myCourseRVAdapter = MyCourseRVAdapter(courseList,requireContext())

        binding.homeMyCourseRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.homeMyCourseRv.adapter = myCourseRVAdapter
        binding.homeMyCourseRv.setHasFixedSize(false)

        myCourseRVAdapter.setMyItemClickListener(object  : MyCourseRVAdapter.MyItemClickListener{
            override fun onItemClick(course: myCourseList) {
                TODO("Not yet implemented")
            } })
    }

    private fun setDramaRankRVAdapter(dramaRankList: ArrayList<dramaList>){
        val dramaRankRVAdapter = DramaRankRVAdapter(dramaRankList,requireContext())

        binding.homeDramaRankRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.homeDramaRankRv.adapter = dramaRankRVAdapter
        binding.homeDramaRankRv.setHasFixedSize(false)

        dramaRankRVAdapter.setMyItemClickListener(object  : DramaRankRVAdapter.MyItemClickListener{
            override fun onItemClick(dramaRank: dramaList) {
                TODO("Not yet implemented")
            } })
    }

    private fun setCourseRVAdapter(scrapCourserankList: ArrayList<coursesSortBySaved>){
        val scrapCourserankRVAdapter = ScrapCourserankRVAdapter(scrapCourserankList,requireContext())

        binding.homeScrapcourseRankRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.homeScrapcourseRankRv.adapter = scrapCourserankRVAdapter
        binding.homeDramaRankRv.setHasFixedSize(false)

        scrapCourserankRVAdapter.setMyItemClickListener(object  : ScrapCourserankRVAdapter.MyItemClickListener{
            override fun onItemClick(scrapCourserank: coursesSortBySaved) {
                TODO("Not yet implemented")
            }
        }) }

    private fun setPlaceRankRVAdapter(placeRankList: ArrayList<spotsSortBySaved>){
        val placeRankRVAdapter = PlaceRankRVAdapter(placeRankList,requireContext())

        binding.homePlaceRankRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.homePlaceRankRv.adapter = placeRankRVAdapter
        binding.homePlaceRankRv.setHasFixedSize(false)

        placeRankRVAdapter.setMyItemClickListener(object  : PlaceRankRVAdapter.MyItemClickListener{
            override fun onItemClick(placeRank: spotsSortBySaved) {
                TODO("Not yet implemented")
            }
        }) }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onHomeLoading() {
        binding.homePb.visibility = View.VISIBLE
    }

    override fun onHomeSuccess(response: HomeResponse) {

        when(response.code) {
            1000 -> {
                response.let {
                    response?.let { setMyCourseRVAdapter((it.result?.myCourseList!!)) }
                    response?.let { setDramaRankRVAdapter((it.result?.dramaList!!)) }
                    response?.let { setCourseRVAdapter((it.result?.coursesSortBySaved!!)) }
                    response?.let { setPlaceRankRVAdapter((it.result?.spotsSortBySaved!!)) }
                    binding.homePb.visibility = View.GONE
                }
            }
        }
    }

    override fun onHomeFailure(code: Int, message: String) {
        Toast.makeText(requireContext(),"통신 에러",Toast.LENGTH_SHORT).show()
    }
}