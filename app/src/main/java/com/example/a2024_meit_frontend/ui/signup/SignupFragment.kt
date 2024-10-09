package com.example.a2024_meit_frontend.ui.signup

import android.app.DatePickerDialog
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
import com.example.a2024_meit_frontend.network.RetrofitClient
import com.example.a2024_meit_frontend.network.SignupRequest
import com.example.a2024_meit_frontend.network.SignupResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Calendar

class SignupFragment : Fragment() {

    private lateinit var nameInput: EditText
    private lateinit var idInput: EditText
    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var passwordConfirmInput: EditText
    private lateinit var birthInput: EditText
    private lateinit var signupButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)

        // View 요소들 초기화
        nameInput = view.findViewById(R.id.input_name)
        idInput = view.findViewById(R.id.input_id)
        emailInput = view.findViewById(R.id.input_email)
        passwordInput = view.findViewById(R.id.input_password)
        passwordConfirmInput = view.findViewById(R.id.input_password_confirm)
        birthInput = view.findViewById(R.id.input_birth)
        signupButton = view.findViewById(R.id.signup_button)

        // 생일 입력란 클릭 시 DatePickerDialog 표시
        birthInput.setOnClickListener {
            showDatePickerDialog()
        }

        // 회원가입 버튼 클릭 리스너 설정
        signupButton.setOnClickListener {
            val username = idInput.text.toString()
            val password = passwordInput.text.toString()
            val passwordConfirm = passwordConfirmInput.text.toString()
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val birth = birthInput.text.toString()

            // 비밀번호 확인 일치 여부 및 모든 필드가 채워졌는지 확인
            if (username.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty() && name.isNotEmpty() && email.isNotEmpty() && birth.isNotEmpty()) {
                if (password == passwordConfirm) {
                    sendSignupRequest(username, password, name, email, birth)
                } else {
                    Toast.makeText(requireContext(), "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "모든 필드를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    // DatePickerDialog 표시
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
            birthInput.setText("$selectedYear-${selectedMonth + 1}-$selectedDay")
        }, year, month, day)

        datePickerDialog.show()
    }

    // 회원가입 요청 보내는 함수
    private fun sendSignupRequest(username: String, password: String, name: String, email: String, birth: String) {
        val request = SignupRequest(username, password, name, email, birth)

        RetrofitClient.instance.signup(request).enqueue(object : Callback<SignupResponse> {
            override fun onResponse(call: Call<SignupResponse>, response: Response<SignupResponse>) {
                if (response.isSuccessful) {
                    val signupResponse = response.body()
                    Toast.makeText(requireContext(), signupResponse?.message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "회원가입 실패: 이미 존재하는 사용자", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                Log.e("Retrofit", "Error: ${t.message}")
                Toast.makeText(requireContext(), "회원가입 실패: 서버와의 통신 오류", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
