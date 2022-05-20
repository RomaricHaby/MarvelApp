package com.marvelapp.data.paging

import org.koin.dsl.module

object PagingModules {
    private val pagingModule = module {
        single {
            CharacterPagingSource(get())
        }
    }

    val all = arrayOf(pagingModule)
}