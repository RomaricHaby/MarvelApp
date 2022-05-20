package com.marvelapp.data.repository

import com.marvelapp.data.datasource.DataSourceModules
import com.marvelapp.data.networking.NetworkingModules
import com.marvelapp.data.paging.PagingModules

object RepositoryModulesTest {
    val all = arrayOf(
        *RepositoryModules.all,
        *PagingModules.all,
        *DataSourceModules.all,
        *NetworkingModules.all
    )
}