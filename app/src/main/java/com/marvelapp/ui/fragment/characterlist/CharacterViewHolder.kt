package com.marvelapp.ui.fragment.characterlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
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
        with(binding) {
            root.setOnClickListener { view ->
                val bundle = bundleOf("characterId" to character.id)
                view.findNavController().navigate(
                    R.id.action_mainFragment_to_detailCharacterFragment,
                    bundle
                )
            }

            viewHolderNameCharacter.text = character.name
            viewHolderCharacterNumberComics.text = character.comics.available.toString()
            viewHolderCharacterNumberStories.text = character.stories.available.toString()
            viewHolderCharacterNumberSerie.text = character.series.available.toString()
            viewHolderCharacterIMG.load(character.thumbnail.path + "." + character.thumbnail.extension) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_foreground)
                transformations(RoundedCornersTransformation())
            }
        }
    }


}