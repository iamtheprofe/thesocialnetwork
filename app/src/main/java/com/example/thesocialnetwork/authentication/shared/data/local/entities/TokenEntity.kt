package com.example.thesocialnetwork.authentication.shared.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TokenEntity(
    @PrimaryKey val token: String
)
