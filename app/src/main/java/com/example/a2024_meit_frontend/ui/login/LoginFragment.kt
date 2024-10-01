package com.example.a2024_meit_frontend.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a2024_meit_frontend.R

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_login.xml 레이아웃을 인플레이트합니다.
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}
