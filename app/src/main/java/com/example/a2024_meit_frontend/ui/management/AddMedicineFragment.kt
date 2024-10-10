package com.example.a2024_meit_frontend.ui.management

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a2024_meit_frontend.R
import com.example.a2024_meit_frontend.databinding.FragmentManagementBinding
import com.google.android.material.bottomnavigation.BottomNavigationView // 추가

class AddMedicineFragment : Fragment() {

    private var _binding: FragmentManagementBinding? = null
    private val binding get() = _binding!!

    private lateinit var navView: BottomNavigationView

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentManagementBinding.inflate(inflater, container, false)

        navView = requireActivity().findViewById(R.id.nav_view)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addmedi, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // BottomNavigationView 보이도록 설정
        val navView = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        navView.visibility = View.VISIBLE // Bottom NavigationView를 보이도록 설정
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
