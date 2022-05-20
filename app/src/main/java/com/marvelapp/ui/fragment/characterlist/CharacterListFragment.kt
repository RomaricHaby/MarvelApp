package com.marvelapp.ui.fragment.characterlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvelapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment : Fragment() {

    companion object {
        private const val TAG = "CharacterListFragment"
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
            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCharacter)

            recyclerView.layoutManager = LinearLayoutManager(context)


            val adapter = CharacterAdapter(it)
            recyclerView.adapter = adapter
        }
    }
}