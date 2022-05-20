package com.marvelapp.ui

import com.marvelapp.ui.fragment.characterdetail.DetailCharacterViewModel
import com.marvelapp.ui.fragment.characterlist.CharacterListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UIModules {
    private val uiModules = module {
        viewModel {
            CharacterListViewModel(get())
        }
        viewModel {
            DetailCharacterViewModel(get(), get())
        }
    }

    val all = arrayOf(uiModules)
}