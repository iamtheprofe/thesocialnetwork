package com.example.thesocialnetwork.data.api

import com.example.thesocialnetwork.data.api.dto.register.RegisterRequest
import com.example.thesocialnetwork.data.api.dto.register.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApi {
    @POST("/api/register")
    fun register(@Body requestData: RegisterRequest): Call<RegisterResponse>
}