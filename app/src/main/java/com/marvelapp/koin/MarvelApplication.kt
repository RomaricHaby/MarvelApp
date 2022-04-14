package com.marvelapp.koin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarvelApplication)
            modules(*KoinModules.all)
        }
    }
}