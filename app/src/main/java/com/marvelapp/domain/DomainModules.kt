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
            GetCharacterComicsUseCase(get())
        }
        factory {
            GetMD5UseCase()
        }
    }

    val all = arrayOf(useCaseModules)
}