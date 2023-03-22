package com.example.thesocialnetwork.data.repository

import com.example.thesocialnetwork.model.RegisterData

interface RegisterRepository {
    suspend fun register(email: String, password: String): RegisterData
}