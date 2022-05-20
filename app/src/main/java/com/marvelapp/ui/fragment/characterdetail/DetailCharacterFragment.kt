package com.marvelapp.ui.fragment.characterdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

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
}