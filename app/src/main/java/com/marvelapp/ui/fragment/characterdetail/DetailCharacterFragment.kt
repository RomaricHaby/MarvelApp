package com.marvelapp.ui.fragment.characterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation

import com.marvelapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCharacterFragment : Fragment() {
    private val viewModel by viewModel<DetailCharacterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.loadCharacterById(requireArguments().getInt("characterId"))
        return inflater.inflate(R.layout.fragment_detail_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewComicsCharacterDetail)
        val characterImageView = view.findViewById<ImageView>(R.id.CharacterDetailImage)
        val characterName = view.findViewById<TextView>(R.id.CharacterDetailName)

        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        viewModel.getCharacter().observe(viewLifecycleOwner){ marvelCharacter ->
            characterName.text = marvelCharacter.name
            characterImageView.load("${marvelCharacter.thumbnail.path}.${marvelCharacter.thumbnail.extension}") {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_foreground)
                transformations(CircleCropTransformation())
            }
        }
        /*viewModel.getComics().observe(viewLifecycleOwner){ comics ->
            recyclerView.adapter = ComicsAdapter(comics)
        }*/
    }
}