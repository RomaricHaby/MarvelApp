package com.marvelapp.data.repository

import com.marvelapp.data.datasource.CharacterRemoteDataSource
import com.marvelapp.data.datasource.CharacterRemoteDataSourceImpl
import com.marvelapp.data.datasource.DataSourceModules
import org.koin.dsl.module

object RepositoryModules {
    private val characterRepository = module {
        single <CharacterRepository> {
            CharacterRepositoryImpl(get())
        }
    }

    val all = arrayOf(characterRepository)
}