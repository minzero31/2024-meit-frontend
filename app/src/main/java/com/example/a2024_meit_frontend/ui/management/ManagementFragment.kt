package com.example.a2024_meit_frontend.ui.management

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a2024_meit_frontend.R
import com.example.a2024_meit_frontend.databinding.FragmentManagementBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ManagementFragment : Fragment() {

    private var _binding: FragmentManagementBinding? = null
    private val binding get() = _binding!!

    private lateinit var navView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManagementBinding.inflate(inflater, container, false)

        // BottomNavigationView 가져오기
        navView = requireActivity().findViewById(R.id.nav_view)

        // 첫 번째 버튼 클릭 시 MySmartMediCabinetFragment로 전환
        binding.buttonSmartPillbox.setOnClickListener {
            changeFragment(1) // MySmartMediCabinetFragment로 전환
        }

        // 두 번째 버튼 클릭 시 CheckRecordFragment로 전환
        binding.buttonCheckMedication.setOnClickListener {
            changeFragment(2) // CheckRecordFragment로 전환
        }

        // 세 번째 버튼 클릭 시 AddMedicineFragment로 전환
        binding.buttonAddMedicine.setOnClickListener {
            changeFragment(3) // AddMedicineFragment로 전환
        }

        return binding.root
    }

    // Fragment 전환 메서드 추가
    private fun changeFragment(index: Int) {
        val fragmentTransaction = parentFragmentManager.beginTransaction()

        when (index) {
            1 -> { // MySmartMediCabinetFragment로 전환
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, MySmartMediCabinetFragment())
            }
            2 -> { // CheckRecordFragment로 전환
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, CheckRecordFragment())
            }
            3 -> { // AddMedicineFragment로 전환
                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, AddMedicineFragment())
            }
        }

        // Bottom NavigationView를 항상 보이도록 설정
        navView.visibility = View.VISIBLE

        fragmentTransaction.commit() // Fragment 전환을 커밋
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
