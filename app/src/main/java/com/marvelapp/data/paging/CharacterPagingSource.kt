package com.marvelapp.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.marvelapp.data.datasource.CharacterRemoteDataSource
import com.marvelapp.model.character.Character

class CharacterPagingSource(
    private val marvelDataSource: CharacterRemoteDataSource
) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val nextOffset = params.key ?: 0
            val response = marvelDataSource.getAllCharacter(nextOffset).getOrNull()
            LoadResult.Page(
                data = response?.second ?: emptyList(),
                prevKey = null,
                nextKey = response?.first
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}