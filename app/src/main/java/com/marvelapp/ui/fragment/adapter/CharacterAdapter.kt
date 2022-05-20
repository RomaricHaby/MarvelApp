package com.marvelapp.ui.fragment.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvelapp.model.character.Character
import com.marvelapp.ui.viewholder.CharacterViewHolder


class CharacterAdapter(
    private var characterList: List<Character>,
) :
    RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount() = characterList.size

}
