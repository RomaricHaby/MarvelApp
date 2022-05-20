package com.marvelapp.ui.fragment.characterdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvelapp.domain.GetCharacterByIdUseCase
import com.marvelapp.model.character.Character
import kotlinx.coroutines.launch

class DetailCharacterViewModel(private val getCharacterByIdUseCase: GetCharacterByIdUseCase) :
    ViewModel() {
    private val character = MutableLiveData<Character>()

    fun getCharacter(): LiveData<Character> {
        return character
    }

    fun loadCharacterById(id: Int) {
        viewModelScope.launch {
            character.postValue(getCharacterByIdUseCase.invoke(id))
        }
        // loadComics(id)
    }

}