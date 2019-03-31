package com.felipesilva.marvelheroes.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Data(
    @SerializedName("data") val data: Results
)

data class Results(
    @SerializedName("results") val results: List<CharactersData>
)

data class CharactersData(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("modified") val lastModify: Date,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail
)

data class Thumbnail (
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)