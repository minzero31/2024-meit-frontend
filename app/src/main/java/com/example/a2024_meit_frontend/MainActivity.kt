package com.example.a2024_meit_frontend

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.a2024_meit_frontend.databinding.ActivityMainBinding
import com.example.a2024_meit_frontend.ui.login.LoginFragment
import com.example.a2024_meit_frontend.ui.onboarding.OnboardingFragment
import com.example.a2024_meit_frontend.ui.signup.SignupFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // ActionBar 숨기기

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // OnboardingFragment를 처음에 보여줍니다.
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, OnboardingFragment())
                .commit()
        }

        // Navigation View는 나중에 필요할 때 보이게 하거나 숨길 수 있습니다.
        val navView: BottomNavigationView = binding.navView
        navView.visibility = View.GONE // 기본적으로 숨깁니다.
    }

    // Fragment 전환 메서드 추가
    // MainActivity.kt 파일에서 changeFragment 메서드를 아래와 같이 수정
    fun changeFragment(index: Int) {
        when (index) {
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, LoginFragment()) // LoginFragment로 전환
                    .commit()
            }
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, SignupFragment()) // SignupFragment로 전환
                    .commit()
            }
        }
    }

}
