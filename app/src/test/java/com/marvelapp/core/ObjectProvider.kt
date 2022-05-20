package com.marvelapp.core

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marvel.model.comic.Comic
import com.marvelapp.model.character.Character
import com.marvelapp.model.character.ResponseCharactersAPI

object ObjectProvider {

    val oneCharacter: ResponseCharactersAPI = Gson().fromJson(
        ResourcesJsonManager.loadResource("one_character.json"),
        object : TypeToken<ResponseCharactersAPI>() {}.type
    )

    val twoCharacters: List<Character> = Gson().fromJson(
        ResourcesJsonManager.loadResource("two_characters.json"),
        object : TypeToken<List<Character>>() {}.type
    )

    val twoComics: List<Comic> = Gson().fromJson(
        ResourcesJsonManager.loadResource("two_comics.json"),
        object : TypeToken<List<Comic>>() {}.type
    )
}