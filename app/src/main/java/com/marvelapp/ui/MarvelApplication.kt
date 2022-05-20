package com.marvelapp.ui

import android.app.Application
import com.marvelapp.data.datasource.DataSourceModules
import com.marvelapp.data.networking.NetworkingModules
import com.marvelapp.data.paging.PagingModules
import com.marvelapp.data.repository.RepositoryModules
import com.marvelapp.domain.DomainModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarvelApplication)
            modules(
                *UIModules.all,
                *RepositoryModules.all,
                *DomainModules.all,
                *DataSourceModules.all,
                *NetworkingModules.all,
                *PagingModules.all
            )
        }
    }
}