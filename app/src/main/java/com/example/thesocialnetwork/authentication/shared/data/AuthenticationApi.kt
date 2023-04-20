package com.example.thesocialnetwork.authentication.shared.data

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("/api/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("/api/signup")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): SignUpResponse

    @POST("/api/forgot_password")
    suspend fun forgotPassword(@Body forgoPassword: ForgotPasswordRequest) : ForgotPasswordResponse
}