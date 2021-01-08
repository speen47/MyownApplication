package com.example.myownapplication.data.network.actor


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ActorsDto(
        val id: Long,
        val cast: List<ActorDto>
)

@Serializable
data class ActorDto(
        val adult: Boolean,
        val gender: Long,
        val id: Long,

        @SerialName("known_for_department")
        val knownForDepartment: String,

        val name: String,

        @SerialName("original_name")
        val originalName: String,

        val popularity: Double,

        @SerialName("profile_path")
        val profilePath: String,

        @SerialName("cast_id")
        val castID: Long,

        val character: String,

        @SerialName("credit_id")
        val creditID: String,

        val order: Long
)
