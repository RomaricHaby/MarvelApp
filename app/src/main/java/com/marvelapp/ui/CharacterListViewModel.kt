package com.marvelapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.marvelapp.domain.GetAllCharacterUseCase
import com.marvelapp.model.character.Character

class CharacterListViewModel(
    getAllCharacterUseCase: GetAllCharacterUseCase
) : ViewModel() {

    val allCharacters: LiveData<List<Character>> = liveData {
        emit(getAllCharacterUseCase())
    }
}