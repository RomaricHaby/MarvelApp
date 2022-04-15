package com.marvelapp.ui

import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModules {
    private val uiModules = module {
        viewModel {
            CharacterListViewModel(get())
        }
    }

    val all = arrayOf(uiModules)
}