package com.vv.core.data.network.api_models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("materials")
data class MaterialApiModel(
    @SerialName("id")
    val id: Int?,
    @SerialName("category")
    val category: String?,
    @SerialName("common_locations")
    val commonLocations: List<String>?,
    @SerialName("description")
    val description: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("cooking_effect")
    val cookingEffect: String?,
    @SerialName("hearts_recovered")
    val heartsRecovered: Double?,
) : AbstractEntryApiModel()

