package com.example.a2024_meit_frontend.ui.management

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a2024_meit_frontend.R
import com.google.android.material.bottomnavigation.BottomNavigationView // 추가

class MySmartMediCabinetFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private lateinit var medicationList: List<MedicationItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mysmartmedicabinet, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // 예시 데이터 생성
        medicationList = listOf(
            MedicationItem("약 이름 1", 1, R.drawable.medi_photo1, 100),
            MedicationItem("약 이름 2", 2, R.drawable.medi_photo2, 80),
            MedicationItem("약 이름 3", 3, R.drawable.medi_photo3, 60),
            MedicationItem("약 이름 4", 4, R.drawable.medi_photo1, 40),
            MedicationItem("약 이름 5", 5, R.drawable.medi_photo2, 20),
            MedicationItem("약 이름 6", 6, R.drawable.medi_photo3, 0)
        )

        // 어댑터 설정
        adapter = MyAdapter(medicationList)
        recyclerView.adapter = adapter

        return view
    }
}

