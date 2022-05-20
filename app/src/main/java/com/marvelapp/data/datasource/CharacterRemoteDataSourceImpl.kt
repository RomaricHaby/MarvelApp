package com.marvelapp.data.datasource

import com.marvelapp.data.networking.CharacterService
import com.marvelapp.model.character.Character
import com.marvelapp.model.character.ResponseCharactersAPI
import retrofit2.Response

class CharacterRemoteDataSourceImpl(
    private val characterService: CharacterService
) : CharacterRemoteDataSource {
    override suspend fun getAllCharacter(): List<Character> {
        return try {
            val response: Response<ResponseCharactersAPI> = characterService.getAllCharacters()

            if (response.isSuccessful) {
                response.body()?.dataCharacters?.results
                    ?: throw IllegalStateException("Body is null")
            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            emptyList()
        }
    }


    override suspend fun getCharacter(id: Int): Result<Character> {
        return try {
            val response: Response<ResponseCharactersAPI> = characterService.getCharacterByID(id)

            if (response.isSuccessful) {
                val character = response.body()?.dataCharacters?.results?.first()

                if (character != null) {
                    return Result.success(character)
                } else throw IllegalStateException(response.message())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}