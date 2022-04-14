package com.marvelapp.koin


import org.koin.dsl.module

object KoinModules {
    private val koinModule = module {
        single {
            //MyRepository()
        }
        factory {
            //Api.createInstance()
        }
    }
    val all = arrayOf(koinModule)
}