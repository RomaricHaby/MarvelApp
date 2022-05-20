package com.marvel.model.common.type

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TypeLanguage(
    @SerializedName("type") val type: String,
    @SerializedName("language") val language: String,
    @SerializedName("text") val text: String
) : Serializable