package com.marvelapp.ui.fragment.characterdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.marvel.model.comic.Comic
import com.marvelapp.R
import com.marvelapp.databinding.ViewHolderComicsBinding

class ComicsViewHolder private constructor(
    private val binding: ViewHolderComicsBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(parent: ViewGroup): ComicsViewHolder {
            return ComicsViewHolder(
                ViewHolderComicsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    fun bind(comic: Comic) {
        with(binding) {
            viewHolderNameComics.text = comic.title
            viewHolderComicsIMG.load("${comic.thumbnail.path}.${comic.thumbnail.extension}") {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_foreground)
                //  transformations(RoundedCornersTransformation())
            }
        }
    }
}