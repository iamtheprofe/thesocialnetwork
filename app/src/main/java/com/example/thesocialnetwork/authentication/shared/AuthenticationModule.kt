package com.example.thesocialnetwork.authentication.shared

import com.example.thesocialnetwork.authentication.shared.data.AuthenticationApi
import com.example.thesocialnetwork.networking.NetworkingModule

object AuthenticationModule {

    private val retrofit = NetworkingModule.provideRetrofit()

    fun provideAuthenticationApi(): AuthenticationApi {
        return retrofit.create(AuthenticationApi::class.java)
    }
}