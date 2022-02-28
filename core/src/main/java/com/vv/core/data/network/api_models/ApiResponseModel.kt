package com.vv.core.data.network.api_models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponseModel<T> (
    @SerialName("data")
    val data: T,
    @SerialName("message")
    val message:String?
)