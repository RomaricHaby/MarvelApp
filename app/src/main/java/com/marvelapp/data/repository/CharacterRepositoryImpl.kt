package com.marvelapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.marvel.model.comic.Comic
import com.marvelapp.data.datasource.CharacterRemoteDataSource
import com.marvelapp.data.paging.CharacterPagingSource
import com.marvelapp.model.character.Character
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl(
    private val characterRemoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {

    override fun getPaginatedCharacter(): Flow<PagingData<Character>> {
        return Pager(PagingConfig(20)) {
            CharacterPagingSource(characterRemoteDataSource)
        }.flow
    }

    override suspend fun getCharacterById(id: Int): Character? {
        return characterRemoteDataSource.getCharacterById(id).getOrNull()
    }

    override suspend fun getCharacterComics(id: Int): List<Comic>? {
        return characterRemoteDataSource.getCharacterComics(id).getOrNull()
    }
}