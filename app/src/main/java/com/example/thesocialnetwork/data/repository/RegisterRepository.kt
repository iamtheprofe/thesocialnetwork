package com.example.thesocialnetwork.data.repository

import com.example.thesocialnetwork.models.Register

interface RegisterRepository {
    fun sendData(email: String, password: String):Register
}