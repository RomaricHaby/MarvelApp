package com.marvelapp.ui

import com.marvelapp.ui.fragment.characterlist.CharacterListViewModel
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