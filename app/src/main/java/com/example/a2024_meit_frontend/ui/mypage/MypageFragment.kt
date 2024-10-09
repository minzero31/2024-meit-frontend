package com.example.a2024_meit_frontend.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a2024_meit_frontend.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {

    private var _binding: FragmentMypageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout directly without ViewModel
        _binding = FragmentMypageBinding.inflate(inflater, container, false)

        // XML에서 정의된 UI 요소가 자동으로 세팅됩니다.

        return binding.root  // Return the root view of the binding
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
