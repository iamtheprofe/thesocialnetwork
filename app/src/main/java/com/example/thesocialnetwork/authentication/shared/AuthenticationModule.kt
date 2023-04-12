package com.example.thesocialnetwork.authentication.shared

import com.example.thesocialnetwork.BuildConfig
import com.example.thesocialnetwork.authentication.shared.data.AuthenticationApi
import com.example.thesocialnetwork.authentication.shared.mocks.MockAuthRepository
import com.example.thesocialnetwork.authentication.shared.repository.RemoteAuthRepository
import com.example.thesocialnetwork.authentication.shared.repository.domain.AuthRepository
import com.example.thesocialnetwork.networking.NetworkingModule

object AuthenticationModule {

    private val retrofit = NetworkingModule.provideRetrofit()

    fun provideAuthenticationApi(): AuthenticationApi {
        return retrofit.create(AuthenticationApi::class.java)
    }

    fun provideRepository(): AuthRepository {
        if (BuildConfig.DEBUG) {
            return MockAuthRepository()
        } else {
            return RemoteAuthRepository()
        }
    }
}