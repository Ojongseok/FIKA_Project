package com.example.fika_project.ui.main.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.R
import com.example.fika_project.databinding.ActivityCourseDetailDramaBinding
import com.example.fika_project.ui.main.SpinnerAdapter
import com.example.fika_project.ui.main.SpinnerModel
import kotlinx.android.synthetic.main.item_spinner.view.*

class CourseDetailDrama : AppCompatActivity() {
    private var _Binding: ActivityCourseDetailDramaBinding? = null
    private val binding get() = _Binding!!
    private val listOfYear = ArrayList<SpinnerModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _Binding = ActivityCourseDetailDramaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailCourseLocationRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CourseDetailLocationAdapter()
        }
        binding.detailCourseTogetherRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CourseDetailTogetherAdapter()
        }

        binding.courseDetailHoldBtn.setOnClickListener {
            startActivity(Intent(this,FolderSelectActivity::class.java))
            overridePendingTransition(R.anim.slide_up_enter,R.anim.slide_up_exit)
        }
        // 스피너 커스텀
        spinnerTest()
    }

    private fun spinnerTest() {
        setupSpinnerYear()
        setupSpinnerHandler()
    }
    private fun setupSpinnerYear() {
        lateinit var spinnerAdapterYear: SpinnerAdapter
        var years : ArrayList<String> = ArrayList()
        years.add("배우")
        years.add("박서준")
        years.add("조이서")
        years.add("서강준")
        years.add("강 다니엘")

        for (i in years.indices) {
            val year = SpinnerModel(years[i])
            listOfYear.add(year)
        }
        spinnerAdapterYear = SpinnerAdapter(this, R.layout.item_spinner, listOfYear)
        binding.spinnerYear.adapter = spinnerAdapterYear
    }
    private fun setupSpinnerHandler() {
        binding.spinnerYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val year = binding.spinnerYear.getItemAtPosition(position) as SpinnerModel
                if (!year.name.equals("배우")) {
                    binding.spinnerYear.txt_name.text = year.name
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    override fun onDestroy() {
        _Binding = null
        super.onDestroy()
    }
}
class CourseDetailLocationAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myhold_location_item_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = 2
}
class CourseDetailTogetherAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.myhold_location_item_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView


    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = 4
}