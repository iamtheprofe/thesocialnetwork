package com.example.thesocialnetwork.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkingModule {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun provideRetrofit(): Retrofit {
        return retrofit
    }
}