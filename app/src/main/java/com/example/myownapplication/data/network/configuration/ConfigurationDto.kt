package com.example.myownapplication.data.network.configuration

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigurationDto(val images: ImagesDto)

@Serializable
data class ImagesDto(
    @SerialName("secure_base_url")
    val baseUrl: String
)