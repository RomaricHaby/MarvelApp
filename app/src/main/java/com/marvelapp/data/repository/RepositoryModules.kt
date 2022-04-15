package com.marvelapp.data.repository

import org.koin.dsl.module

object RepositoryModules {
    private val characterRepository = module {
        single<CharacterRepository> {
            CharacterRepositoryImpl(get())
        }
    }

    val all = arrayOf(characterRepository)
}