package com.fika.fika_project.ui.main.explore.filter_drama

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import com.fika.fika_project.databinding.FragmentExploreDramaPageBinding

class ExploreDramaPage : Fragment(), ExploreDramaView {
    private lateinit var binding: FragmentExploreDramaPageBinding
    var filter : String = "all"
    val service = ExploreService(this, filter)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentExploreDramaPageBinding.inflate(inflater, container, false)

        binding.filterDramaBtn.setOnClickListener {
            val menuList =arrayOf("전체","梨泰院クラス","愛の不時着")
            val dialog = AlertDialog.Builder(requireContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar)
            dialog.setTitle("장르").setItems(menuList, DialogInterface.OnClickListener { dialogInterface, i ->
                binding.genreFilterTv.text = menuList[i]

            })
            dialog.show()
        }
        binding.filterDramaActorBtn.setOnClickListener {
            val menuList =arrayOf("전체","キム・ダミ","パク・ソジュン","アン・ボヒョン")
           val dialog = AlertDialog.Builder(requireContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar)
            dialog.setTitle("배우").setItems(menuList, DialogInterface.OnClickListener { dialogInterface, i ->
                binding.filterActorTv.text = menuList[i]

            })
            dialog.show()
        }
        binding.filterDramaSortingBtn.setOnClickListener {
            val menuList =arrayOf("最新順","イロハ順","評点の高い順")
            val dialog = AlertDialog.Builder(requireContext(),android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar)
            dialog.setTitle("정렬").setItems(menuList, DialogInterface.OnClickListener { dialogInterface, i ->
                binding.filterSortingTv.text = menuList[i]

            })
            dialog.show()
        }
        service.tryLoadExploreDrama()
        return binding.root
    }
    override fun onExploreLoading() {
        binding.progressbarDramaPage.visibility = View.VISIBLE
    }
    override fun onExploreSuccess(response: ExploreDramaResponse) {
        when(response.code) {

            1000 -> {
                binding.progressbarDramaPage.visibility = View.GONE
                response?.let {
                    setDramalist(it.result!!)
                }
            }
        }
    }
    private fun setDramalist(dramalist: ArrayList<result>) {
        binding.exploreDramaPageRecyclerview.layoutManager = GridLayoutManager(requireContext(),3)
        binding.exploreDramaPageRecyclerview.adapter = ExploreDramaPageAdapter(dramalist, requireContext())
        binding.exploreDranaPageSearchNumber.text = dramalist.size.toString() + "つ"
    }
    override fun onExploreFailure(code: Int, message: String) {
    }
}