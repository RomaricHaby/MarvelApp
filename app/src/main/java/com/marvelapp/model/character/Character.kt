package com.marvelapp.model.character

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import com.marvelapp.model.common.Thumbnail
import java.io.Serializable


data class Character(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("comics") val comics: ExtraDataCharacter,
    @SerializedName("series") val series: ExtraDataCharacter,
    @SerializedName("stories") val stories: ExtraDataCharacter,
    @SerializedName("events") val events: ExtraDataCharacter
) : Serializable {

    companion object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Character,
            newItem: Character
        ): Boolean {
            return oldItem == newItem
        }
    }
}
