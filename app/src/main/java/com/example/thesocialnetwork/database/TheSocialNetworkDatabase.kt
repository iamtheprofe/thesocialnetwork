package com.example.thesocialnetwork.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thesocialnetwork.authentication.shared.data.local.daos.TokenDao
import com.example.thesocialnetwork.authentication.shared.data.local.entities.TokenEntity

@Database(
    entities = [
        TokenEntity::class
    ],
    version = 1
)
abstract class TheSocialNetworkDatabase : RoomDatabase() {
    abstract fun tokenDao(): TokenDao

    companion object {
        private lateinit var database: TheSocialNetworkDatabase

        fun buildDatabase(context: Context): TheSocialNetworkDatabase {
            if (!this::database.isInitialized) {
                synchronized(this) {
                    database = Room.databaseBuilder(
                        context,
                        TheSocialNetworkDatabase::class.java, context.packageName.toString()
                    ).build()
                }
            }
            return database
        }
    }
}
