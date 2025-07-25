package com.example.firstappandmaybethelast.musicdata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class Music(
    @SerialName("_id") var _id: String = UUID.randomUUID().toString(),
    @SerialName("title") var title: String? = null,
    @SerialName("artist") var artist: String? = null,
    @SerialName("imageUrl") var imageUrl: String? = null,
    @SerialName("streamUrl") var streamUrl: String? = null,
    @SerialName("genre") var genre: String? = null,
    @SerialName("duration_seconds") var durationSeconds: Int? = null
)
