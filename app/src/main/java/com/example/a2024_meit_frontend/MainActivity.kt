package com.example.a2024_meit_frontend

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.a2024_meit_frontend.databinding.ActivityMainBinding
import com.example.a2024_meit_frontend.ui.home.HomeFragment
import com.example.a2024_meit_frontend.ui.login.LoginFragment
import com.example.a2024_meit_frontend.ui.management.ManagementFragment
import com.example.a2024_meit_frontend.ui.mypage.MypageFragment
import com.example.a2024_meit_frontend.ui.onboarding.OnboardingFragment
import com.example.a2024_meit_frontend.ui.signup.SignupFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var homeFragment: HomeFragment? = null
    private var managementFragment: ManagementFragment? = null
    private var mypageFragment: MypageFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // ActionBar 숨기기

        // ViewBinding 설정
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // OnboardingFragment를 처음에 보여줍니다.
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, OnboardingFragment())
                .commit()
        }

        // Navigation View 설정
        val navView: BottomNavigationView = binding.navView
        navView.visibility = View.GONE // 기본적으로 숨김

        // BottomNavigationView 아이템 클릭 리스너 설정
        navView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    changeFragment(3) // HomeFragment로 전환
                    true
                }
                R.id.navigation_dashboard -> {
                    changeFragment(4) // ManagementFragment로 전환
                    true
                }
                R.id.navigation_notifications -> {
                    changeFragment(5) // MypageFragment로 전환
                    true
                }
                else -> false
            }
        }
    }

    // Fragment 전환 메서드 추가 (유지)
    fun changeFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()

        when (index) {
            1 -> { // LoginFragment로 전환
                transaction.replace(R.id.nav_host_fragment_activity_main, LoginFragment())
                    .commit()
                binding.navView.visibility = View.GONE // LoginFragment에서는 BottomNavigationView 숨김
            }
            2 -> { // SignupFragment로 전환
                transaction.replace(R.id.nav_host_fragment_activity_main, SignupFragment())
                    .commit()
                binding.navView.visibility = View.GONE // SignupFragment에서도 BottomNavigationView 숨김
            }
            3 -> { // HomeFragment로 전환
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                }
                transaction.replace(R.id.nav_host_fragment_activity_main, homeFragment!!)
                    .commit()

                // 네비게이션 세팅
                val navController = findNavController(R.id.nav_host_fragment_activity_main)
                binding.navView.setupWithNavController(navController)

                binding.navView.visibility = View.VISIBLE // BottomNavigationView 표시
            }
            4 -> { // ManagementFragment로 전환
                if (managementFragment == null) {
                    managementFragment = ManagementFragment()
                }
                transaction.replace(R.id.nav_host_fragment_activity_main, managementFragment!!)
                    .commit()
                binding.navView.visibility = View.VISIBLE // BottomNavigationView 표시
            }
            5 -> { // MypageFragment로 전환
                if (mypageFragment == null) {
                    mypageFragment = MypageFragment()
                }
                transaction.replace(R.id.nav_host_fragment_activity_main, mypageFragment!!)
                    .commit()
                binding.navView.visibility = View.VISIBLE // BottomNavigationView 표시
            }
        }
    }
}
