package com.example.fika_project.ui.main.tour

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fika_project.R
import com.example.fika_project.databinding.FragmentTourActorSelectBinding
import com.example.fika_project.databinding.FragmentTourBinding
import kotlinx.android.synthetic.main.fragment_tour_actor_select.*

class ActorSelectFragment : Fragment() {
    private var _binding: FragmentTourActorSelectBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTourActorSelectBinding.inflate(inflater, container, false)

        actorSelectEvent()

        binding.actorSelectBackLayout.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }

        return binding.root
    }
    fun actorSelectEvent() {
        binding.actorSelectItem1.setOnClickListener {
            val intent = Intent(requireContext(),ActorDetailSceneActivity::class.java)
            intent.putExtra("actorName",actor_select_item1.text.toString())
            startActivity(intent)
        }
        binding.actorSelectItem2.setOnClickListener {
            val intent = Intent(requireContext(),ActorDetailSceneActivity::class.java)
            intent.putExtra("actorName",actor_select_item2.text.toString())
            startActivity(intent)
        }
        binding.actorSelectItem3.setOnClickListener {
            val intent = Intent(requireContext(),ActorDetailSceneActivity::class.java)
            intent.putExtra("actorName",actor_select_item3.text.toString())
            startActivity(intent)
        }
        binding.actorSelectItem4.setOnClickListener {
            val intent = Intent(requireContext(),ActorDetailSceneActivity::class.java)
            intent.putExtra("actorName",actor_select_item4.text.toString())
            startActivity(intent)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}