package com.marvelapp.data.repository

import com.marvelapp.data.datasource.CharacterRemoteDataSource
import com.marvelapp.model.character.Character

class CharacterRepositoryImpl(
    private val characterRemoteDataSource: CharacterRemoteDataSource
) : CharacterRepository {
    override suspend fun getPaginatedCharacter(): List<Character> {
        return characterRemoteDataSource.getAllCharacter()
    }
}