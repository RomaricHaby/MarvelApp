package com.marvelapp.domain

import org.koin.dsl.module

object DomainModules {
    private val useCaseModules = module {
        factory {
            GetAllCharacterUseCase(get())
        }
        factory {
            GetCharacterByIdUseCase(get())
        }
        factory {
            GetMD5UseCase()
        }
    }

    val all = arrayOf(useCaseModules)
}