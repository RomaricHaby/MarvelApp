package com.marvelapp.domain


import com.marvelapp.data.repository.CharacterRepository
import com.marvelapp.model.character.Character

class GetAllCharacterUseCase(private val characterRepository: CharacterRepository) {

    suspend operator fun invoke(): List<Character> {
        return characterRepository.getPaginatedCharacter()
    }

}