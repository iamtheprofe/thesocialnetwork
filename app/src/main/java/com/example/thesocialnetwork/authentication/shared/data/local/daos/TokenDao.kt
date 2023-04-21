package com.example.thesocialnetwork.authentication.shared.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.thesocialnetwork.authentication.shared.data.local.entities.TokenEntity

@Dao
interface TokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveToken(tokenEntity: TokenEntity)
}
