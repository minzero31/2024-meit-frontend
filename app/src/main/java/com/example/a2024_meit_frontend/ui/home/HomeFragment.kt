package com.example.a2024_meit_frontend.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a2024_meit_frontend.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // RecyclerView 설정
        val medicationList = listOf(
            Medication("오전 10시", listOf("약1", "약2", "약3")),
            Medication("오후 2시", listOf("약4", "약5", "약6")),
            Medication("저녁 8시", listOf("약7", "약8", "약9"))
        )

        val adapter = MedicationAdapter(medicationList)
        binding.medicationRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.medicationRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
