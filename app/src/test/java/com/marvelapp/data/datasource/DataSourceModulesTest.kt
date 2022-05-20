package com.marvelapp.data.datasource

import com.marvelapp.data.networking.NetworkingModules
import com.marvelapp.data.paging.PagingModules

object DataSourceModulesTest {
    val all = arrayOf(*PagingModules.all, *DataSourceModules.all, *NetworkingModules.all)
}