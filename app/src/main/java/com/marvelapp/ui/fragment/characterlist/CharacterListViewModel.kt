package com.marvelapp.ui.fragment.characterlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.marvelapp.domain.GetAllCharacterUseCase
import com.marvelapp.model.character.Character
import kotlinx.coroutines.flow.Flow

class CharacterListViewModel(getAllCharacterUseCase: GetAllCharacterUseCase
) : ViewModel() {

    val allCharacters: Flow<PagingData<Character>> =
        getAllCharacterUseCase().cachedIn(viewModelScope)
}