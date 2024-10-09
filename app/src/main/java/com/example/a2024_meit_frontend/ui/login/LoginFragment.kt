package com.example.a2024_meit_frontend.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.a2024_meit_frontend.R
import com.example.a2024_meit_frontend.network.LoginRequest
import com.example.a2024_meit_frontend.network.LoginResponse
import com.example.a2024_meit_frontend.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private lateinit var inputId: EditText
    private lateinit var inputPassword: EditText
    private lateinit var loginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment_login.xml 레이아웃을 인플레이트합니다.
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // View 초기화
        inputId = view.findViewById(R.id.input_id)
        inputPassword = view.findViewById(R.id.input_password)
        loginButton = view.findViewById(R.id.login_button)

        // 로그인 버튼 클릭 이벤트 처리
        loginButton.setOnClickListener {
            val username = inputId.text.toString()
            val password = inputPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                sendLoginRequest(username, password)
            } else {
                Toast.makeText(requireContext(), "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    // 서버에 로그인 요청을 보내는 함수
    private fun sendLoginRequest(username: String, password: String) {
        val request = LoginRequest(username, password)

        // Retrofit을 이용한 로그인 요청
        val apiService = RetrofitClient.instance  // 이미 생성된 instance 사용
        apiService.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    Toast.makeText(requireContext(), loginResponse?.message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "로그인 실패: 잘못된 자격 증명", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("Retrofit", "Error: ${t.message}")
                Toast.makeText(requireContext(), "로그인 실패: 서버와의 통신 오류", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
