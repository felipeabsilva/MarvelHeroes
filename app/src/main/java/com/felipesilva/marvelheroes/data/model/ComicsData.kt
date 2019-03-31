package com.felipesilva.marvelheroes.data.model

import com.google.gson.annotations.SerializedName

data class ComicsData(
    @SerializedName("data") val data: ComicsResults
)

data class ComicsResults(
    @SerializedName("results") val results: List<ComicsDetails>
)

data class ComicsDetails(
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail: ComicsThumbnail
)

data class ComicsThumbnail (
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)

