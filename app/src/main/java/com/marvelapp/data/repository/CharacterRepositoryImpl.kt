package com.marvelapp.data.repository

import com.marvelapp.data.datasource.CharacterRemoteDataSource

class CharacterRepositoryImpl(val characterRemoteDataSource: CharacterRemoteDataSource) : CharacterRepository {
    override fun getPaginatedCharacter() {
        TODO("Not yet implemented")
    }
}