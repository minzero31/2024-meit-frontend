package com.example.a2024_meit_frontend.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a2024_meit_frontend.MainActivity
import com.example.a2024_meit_frontend.R

class OnboardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_onboarding, container, false)

        // 로그인 버튼 클릭 리스너 설정
        val goLoginButton = rootView.findViewById<View>(R.id.go_login_button) // ID 변경
        goLoginButton.setOnClickListener {
            (activity as MainActivity).changeFragment(1) // LoginFragment로 변경
        }
        // 회원가입 버튼 클릭 리스너 설정
        val goSignupButton = rootView.findViewById<View>(R.id.go_signup_button) // ID 변경
        goSignupButton.setOnClickListener {
            (activity as MainActivity).changeFragment(2) // SignupFragment로 변경
        }

        return rootView
    }
}
