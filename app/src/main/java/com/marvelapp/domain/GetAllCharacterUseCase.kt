package com.marvelapp.domain


import androidx.paging.PagingData
import com.marvelapp.data.repository.CharacterRepository
import com.marvelapp.model.character.Character
import kotlinx.coroutines.flow.Flow

class GetAllCharacterUseCase(private val characterRepository: CharacterRepository) {
    operator fun invoke(): Flow<PagingData<Character>> {
        return characterRepository.getPaginatedCharacter()
    }
}