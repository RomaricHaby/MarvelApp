package com.marvelapp.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.marvelapp.R
import com.marvelapp.databinding.ViewHolderCharacterBinding
import com.marvelapp.model.character.Character

class CharacterViewHolder private constructor(
    private val binding: ViewHolderCharacterBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup): CharacterViewHolder {
            return CharacterViewHolder(
                ViewHolderCharacterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(character: Character) {
        binding.viewHolderNameCharacter.text = character.name
        binding.viewHolderCharacterNumberComics.text = character.comics.available.toString()
        binding.viewHolderCharacterNumberStories.text = character.stories.available.toString()
        binding.viewHolderCharacterNumberSerie.text = character.series.available.toString()
        binding.viewHolderCharacterIMG.load(character.thumbnail.path + "." + character.thumbnail.extension) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_foreground)
            transformations(RoundedCornersTransformation())
        }


    }


}