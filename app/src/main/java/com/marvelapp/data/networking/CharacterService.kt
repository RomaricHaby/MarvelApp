package com.marvelapp.data.networking

import com.marvel.model.comic.ResponseComicsAPI
import com.marvelapp.model.character.ResponseCharactersAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {
    //Characters
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
        @Query("offset") offset: Int
    ): Response<ResponseCharactersAPI>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacterByID(
        @Path("id") id: Int,
    ): Response<ResponseCharactersAPI>

    @GET("/v1/public/characters/{id}/comics")
    suspend fun getCharacterComics(
        @Path("id") id: Int,
    ): Response<ResponseComicsAPI>

}