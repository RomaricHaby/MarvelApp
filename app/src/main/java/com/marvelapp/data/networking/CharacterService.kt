package com.marvelapp.data.networking

import com.marvelapp.model.character.ResponseCharactersAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {
    //Characters
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(): Response<ResponseCharactersAPI>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacterByID(
        @Path("id") id: String,
    ): Response<ResponseCharactersAPI>
}