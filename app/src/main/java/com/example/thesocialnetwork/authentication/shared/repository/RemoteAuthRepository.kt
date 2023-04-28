package com.example.thesocialnetwork.authentication.shared.repository

import com.example.thesocialnetwork.authentication.shared.AuthenticationModule
import com.example.thesocialnetwork.authentication.shared.data.AuthenticationApi
import com.example.thesocialnetwork.authentication.shared.data.LoginRequest
import com.example.thesocialnetwork.authentication.shared.data.SignUpRequest
import com.example.thesocialnetwork.authentication.shared.data.local.daos.TokenDao
import com.example.thesocialnetwork.authentication.shared.data.local.entities.TokenEntity
import com.example.thesocialnetwork.authentication.shared.repository.domain.AuthRepository

class RemoteAuthRepository(
    private val api: AuthenticationApi = AuthenticationModule.provideAuthenticationApi(),
    private val dao: TokenDao = AuthenticationModule.provideTokenDao()
) : AuthRepository {

    override suspend fun login(email: String, password: String): String? {
        val loginRequest = LoginRequest(email, password)

        return try {
            val response = api.login(loginRequest)
            val token = response.token
            dao.saveToken(TokenEntity(token))
            token
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }
    }

    override suspend fun singUp(email: String, password: String): String? {
        val signUpRequest = SignUpRequest(email, password)
        return try {
            val response = api.signUp(signUpRequest)
            response.token
        } catch (exception: Exception) {
            exception.printStackTrace()
            null
        }
    }

    override suspend fun getToken(): String? {
        return dao.getToken()?.token
    }

}