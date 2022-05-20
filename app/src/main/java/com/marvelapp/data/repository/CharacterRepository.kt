package com.marvelapp.data.repository

import com.marvelapp.model.character.Character

interface CharacterRepository {
    suspend fun getPaginatedCharacter(): List<Character>
    suspend fun getCharacterById(id: Int): Character?
}