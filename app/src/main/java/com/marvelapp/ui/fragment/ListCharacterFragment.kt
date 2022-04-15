package com.marvelapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marvelapp.R
import com.marvelapp.ui.CharacterListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListCharacterFragment : Fragment() {

    companion object {
        private const val TAG = "ListCharacterFragment"
    }

    private val viewModel by viewModel<CharacterListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.allCharacters.observe(viewLifecycleOwner) {
            Log.i(TAG, "onViewCreated: $it")
        }
    }
}