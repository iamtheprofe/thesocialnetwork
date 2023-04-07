package com.example.thesocialnetwork.authentication.shared.data

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("/api/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("/api/signup")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): SignUpResponse
}