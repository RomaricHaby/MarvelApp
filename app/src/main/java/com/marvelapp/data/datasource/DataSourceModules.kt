package com.marvelapp.data.datasource

import org.koin.dsl.module

object DataSourceModules {
    private val characterDataSourceModule = module {
        single<CharacterRemoteDataSource> {
            CharacterRemoteDataSourceImpl(get())
        }
    }

    val all = arrayOf(characterDataSourceModule)
}