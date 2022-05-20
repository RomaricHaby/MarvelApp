package com.marvelapp.ui.fragment.characterdetail

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvel.model.comic.Comic

class ComicsAdapter (private val comics: List<Comic>):
    RecyclerView.Adapter<ComicsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(comics[position])
    }

    override fun getItemCount(): Int {
        return comics.size
    }
}