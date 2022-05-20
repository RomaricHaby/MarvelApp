package com.marvel.model.common.type

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TypePrice(
    @SerializedName("type") val type: String,
    @SerializedName("price") val price: Float,
) : Serializable
