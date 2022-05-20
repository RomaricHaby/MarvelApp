package com.marvelapp.data.datasource

import com.marvel.model.comic.Comic
import com.marvel.model.comic.ResponseComicsAPI
import com.marvelapp.data.networking.CharacterService
import com.marvelapp.model.character.Character
import com.marvelapp.model.character.ResponseCharactersAPI
import retrofit2.Response

class CharacterRemoteDataSourceImpl(
    private val characterService: CharacterService
) : CharacterRemoteDataSource {

    override suspend fun getAllCharacter(offset: Int): Result<Pair<Int, List<Character>>> {
        return try {
            val response: Response<ResponseCharactersAPI> =
                characterService.getAllCharacters(offset)

            if (response.isSuccessful) {
                val nextOffset = response.body()?.dataCharacters?.offset?.plus(20) ?: offset
                val characterList = response.body()?.dataCharacters?.results
                Result.success(Pair(nextOffset, characterList ?: emptyList()))

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }


    override suspend fun getCharacterById(id: Int): Result<Character> {
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

    override suspend fun getCharacterComics(id: Int): Result<List<Comic>?> {
        return try {
            val response: Response<ResponseComicsAPI> = characterService.getCharacterComics(id)

            if (response.isSuccessful) {
                val comics = response.body()?.dataComics?.results

                if (comics != null) {
                    return Result.success(comics)
                } else throw IllegalStateException(response.message())

            } else throw IllegalStateException(response.message())

        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}