package com.fika.fika_project.ui.main.mycourse.course_edit
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fika.fika_project.R
import com.fika.fika_project.databinding.FragmentMyCourseSaveStateBinding
import com.fika.fika_project.ui.main.mycourse.course_edit.state_save.CourseViewResponse
import com.fika.fika_project.ui.main.mycourse.course_edit.state_save.CourseViewService
import com.fika.fika_project.ui.main.mycourse.course_edit.state_save.CourseViewView
import com.fika.fika_project.ui.main.mycourse.course_edit.state_save.spotList
import kotlinx.android.synthetic.main.drama_info_course_item.view.*
import kotlinx.android.synthetic.main.mycourse_save_state_list.view.*
import kotlinx.android.synthetic.main.mycourse_view_item_list.view.*
import kotlinx.android.synthetic.main.mycourse_view_item_list.view.course_item_number

class MyCourseSaveState : Fragment(),CourseViewView {
    private var _binding: FragmentMyCourseSaveStateBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyCourseSaveStateBinding.inflate(inflater, container, false)

        val courseId = arguments?.getInt("courseId",0)!!
        Log.d("TAG",courseId.toString())
        val service = CourseViewService(this,courseId)
        service.tryCourseView()



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onExploreSuccess(response: CourseViewResponse) {
        when(response.code) {
            1000 -> {
                response.let {
                    binding.saveStateRecyclerview.layoutManager = LinearLayoutManager(requireContext())
                    binding.saveStateRecyclerview.adapter = SaveStateAdapter(it.result?.spotList!!,requireContext())
                }
            }
        }
    }

    override fun onExploreFailure() {
    }
}
class SaveStateAdapter(val spotList : ArrayList<spotList>,val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mycourse_save_state_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView
        view.course_edit_title.text = spotList[position].spotTitle
        view.course_edit_sub.text = spotList[position].shortAddress + "·" + spotList[position].type
        Glide.with(context).load(spotList[position].spotImageUrl).into(view.course_edit_image)

        view.course_item_number.text = (position+1).toString()
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = spotList.size
}