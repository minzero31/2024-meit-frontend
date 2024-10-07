package com.example.a2024_meit_frontend.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// 로그인 요청 모델
data class LoginRequest(
    val cus_ID: String,
    val cus_pwd: String
)

// 회원가입 요청 모델
data class SignupRequest(
    val cus_ID: String,
    val cus_pwd: String,
    val cus_name: String,
    val cus_email: String,
    val cus_birth: String
)

// 로그인 응답 모델
data class LoginResponse(
    val message: String
)

// 회원가입 응답 모델
data class SignupResponse(
    val message: String
)

interface ApiService {
    @POST("/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("/signup")
    fun signup(@Body request: SignupRequest): Call<SignupResponse>
}
