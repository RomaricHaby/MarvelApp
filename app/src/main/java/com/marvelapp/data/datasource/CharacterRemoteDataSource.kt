package com.marvelapp.data.datasource

import com.marvelapp.model.character.Character

interface CharacterRemoteDataSource {
    suspend fun getAllCharacter(): List<Character>
}