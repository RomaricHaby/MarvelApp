package com.marvelapp.data.datasource

import com.marvelapp.data.networking.CharacterService

class CharacterRemoteDataSourceImpl(val characterService: CharacterService) : CharacterRemoteDataSource {
    override fun getAllCharacter() {
        TODO("Not yet implemented")
    }
}