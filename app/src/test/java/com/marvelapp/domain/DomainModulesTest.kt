package com.marvelapp.domain

import com.marvelapp.data.datasource.DataSourceModules
import com.marvelapp.data.networking.NetworkingModules
import com.marvelapp.data.paging.PagingModules
import com.marvelapp.data.repository.RepositoryModules

object DomainModulesTest {
    val all = arrayOf(
        *DomainModules.all,
        *RepositoryModules.all,
        *PagingModules.all,
        *DataSourceModules.all,
        *NetworkingModules.all
    )
}