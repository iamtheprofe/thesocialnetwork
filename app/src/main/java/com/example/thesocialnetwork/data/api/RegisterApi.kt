package com.example.thesocialnetwork.data.api

import com.example.thesocialnetwork.data.api.dto.user.RegisterRequestDto
import com.example.thesocialnetwork.data.api.dto.user.RegisterResponseDto
import com.example.thesocialnetwork.signup.SignUpActivity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST("/register")
    fun sendData(@Body requestData: RegisterRequestDto): Call<RegisterResponseDto>
}