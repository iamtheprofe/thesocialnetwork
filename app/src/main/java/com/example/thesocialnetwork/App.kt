package com.example.thesocialnetwork

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        lateinit var APP_CONTEXT: Context
    }

    override fun onCreate() {
        super.onCreate()
        APP_CONTEXT = this
    }
}