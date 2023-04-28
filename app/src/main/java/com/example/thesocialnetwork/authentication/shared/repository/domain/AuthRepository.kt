package com.example.thesocialnetwork.authentication.shared.repository.domain

interface AuthRepository {

    suspend fun login(email: String, password: String): String?

    suspend fun singUp(email: String, password: String): String?
    suspend fun getToken(): String?

}