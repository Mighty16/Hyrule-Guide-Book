package com.vv.core.data.network.api_models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("monsters")
data class MonsterApiModel(
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
    @SerialName("drops")
    val drops: List<String>?,
) : AbstractEntryApiModel()