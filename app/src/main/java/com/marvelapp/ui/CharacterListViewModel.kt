package com.marvelapp.ui

import androidx.lifecycle.ViewModel
import com.marvelapp.domain.GetAllCharacterUseCase

class CharacterListViewModel (val getAllCharacterUseCase: GetAllCharacterUseCase): ViewModel() {
}