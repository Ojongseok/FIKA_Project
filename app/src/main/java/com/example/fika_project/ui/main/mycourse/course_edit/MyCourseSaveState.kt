package com.example.fika_project.ui.main.mycourse.course_edit
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentMyCourseSaveStateBinding
import com.example.fika_project.databinding.FragmentMycourseBinding
import com.example.fika_project.databinding.FragmentMypageBinding
import kotlinx.android.synthetic.main.mycourse_view_item_list.view.*

class MyCourseSaveState : Fragment() {
    private var _binding: FragmentMyCourseSaveStateBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMyCourseSaveStateBinding.inflate(inflater, container, false)

        binding.saveStateRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.saveStateRecyclerview.adapter = SaveStateAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
class SaveStateAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mycourse_save_state_list,parent,false)

        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val view = (holder as CustomViewHolder).itemView

        view.course_item_number.text = (position+1).toString()
    }
    inner class CustomViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    override fun getItemCount() = 7
}