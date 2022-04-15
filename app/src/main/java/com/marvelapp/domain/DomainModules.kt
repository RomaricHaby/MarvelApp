package com.marvelapp.domain

import com.marvelapp.ui.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DomainModules {
    private val useCaseModules = module {
        factory {
            GetAllCharacterUseCase(get())
        }
    }

    val all = arrayOf(useCaseModules)
}