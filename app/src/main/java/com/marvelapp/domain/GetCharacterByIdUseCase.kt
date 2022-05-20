package com.marvelapp.domain

import com.marvelapp.data.repository.CharacterRepository
import com.marvelapp.model.character.Character

class GetCharacterByIdUseCase(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(id: Int): Character? {
        return characterRepository.getCharacterById(id)
    }
}