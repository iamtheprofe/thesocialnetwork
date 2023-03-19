package com.example.thesocialnetwork.data.repository

import com.example.thesocialnetwork.data.api.RegisterApi
import com.example.thesocialnetwork.data.api.dto.user.RegisterRequestDto
import com.example.thesocialnetwork.data.api.dto.user.RegisterResponseDto
import com.example.thesocialnetwork.models.Register
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterRepositoryImpl(private val registerApi: RegisterApi):RegisterRepository {

    private val retrofit = Retrofit.Builder()
         .baseUrl("https://reqres.in/api")
         .addConverterFactory(GsonConverterFactory.create())
         .build()

   private val api = retrofit.create(RegisterApi::class.java)

    override fun sendData(email: String, password: String): Register {
    val response = api.sendData(RegisterRequestDto(email, password)).execute()
        if(response.isSuccessful &&response.body()!=null) {
            return Register(response.body().token)
        }
    }

}