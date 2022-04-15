package com.marvelapp.data.datasource

import com.marvelapp.ui.CharacterListViewModel
import com.marvelapp.ui.UIModules
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DataSourceModules {
    private val characterDataSourceModule = module {
       single <CharacterRemoteDataSource> {
           CharacterRemoteDataSourceImpl(get())
       }
    }

    val all = arrayListOf(characterDataSourceModule)
}