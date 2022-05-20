package com.marvelapp.data.repository

import com.marvel.model.comic.Comic
import com.marvelapp.model.character.Character

interface CharacterRepository {
    suspend fun getPaginatedCharacter(): List<Character>
    suspend fun getCharacterById(id: Int): Character?
    suspend fun getCharacterComics(id: Int): List<Comic>?
}