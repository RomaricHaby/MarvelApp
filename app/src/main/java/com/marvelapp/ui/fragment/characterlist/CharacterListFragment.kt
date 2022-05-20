package com.marvelapp.ui.fragment.characterlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvelapp.R
import com.marvelapp.model.character.Character
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment : Fragment() {

    private val viewModel by viewModel<CharacterListViewModel>()
    private val adapter = CharacterAdapter(Character)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCharacter)

        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = adapter
        
        lifecycleScope.launchWhenStarted {
            viewModel.allCharacters.collectLatest { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}