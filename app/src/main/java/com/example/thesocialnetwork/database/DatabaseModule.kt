package com.example.thesocialnetwork.database

import com.example.thesocialnetwork.App

object DatabaseModule {
    fun provideDatabase(): TheSocialNetworkDatabase {
        return TheSocialNetworkDatabase.buildDatabase(context = App.APP_CONTEXT)
    }
}
