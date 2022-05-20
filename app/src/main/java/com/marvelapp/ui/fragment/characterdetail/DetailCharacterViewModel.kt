package com.marvelapp.ui.fragment.characterdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marvel.model.comic.Comic
import com.marvelapp.domain.GetCharacterByIdUseCase
import com.marvelapp.domain.GetCharacterComicsUseCase
import com.marvelapp.model.character.Character
import kotlinx.coroutines.launch

class DetailCharacterViewModel(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val getCharacterComicsUseCase: GetCharacterComicsUseCase
) :
    ViewModel() {
    private val character = MutableLiveData<Character>()
    private val comics = MutableLiveData<List<Comic>>()

    fun getCharacter(): LiveData<Character> {
        return character
    }

    fun getComics(): LiveData<List<Comic>> {
        return comics
    }


    fun loadCharacterById(id: Int) {
        viewModelScope.launch {
            character.postValue(getCharacterByIdUseCase.invoke(id))
        }
        loadComics(id)
    }

    private fun loadComics(id: Int) {
        viewModelScope.launch {
            comics.postValue(getCharacterComicsUseCase.invoke(id))
        }
    }
}