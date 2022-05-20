package com.marvelapp.data.repository

import androidx.paging.PagingData
import com.marvel.model.comic.Comic
import com.marvelapp.model.character.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getPaginatedCharacter(): Flow<PagingData<Character>>
    suspend fun getCharacterById(id: Int): Character?
    suspend fun getCharacterComics(id: Int): List<Comic>?
}