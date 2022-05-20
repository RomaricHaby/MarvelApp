package com.marvelapp.domain

import com.marvel.model.comic.Comic
import com.marvelapp.data.repository.CharacterRepository

class GetCharacterComicsUseCase(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(id: Int): List<Comic>? {
        return characterRepository.getCharacterComics(id)
    }
}