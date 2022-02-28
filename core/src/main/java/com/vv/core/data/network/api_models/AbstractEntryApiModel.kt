package com.vv.core.data.network.api_models

import com.vv.core.data.network.AbstractEntryApiModelDeserializer
import kotlinx.serialization.Serializable

@Serializable(with = AbstractEntryApiModelDeserializer::class)
abstract class AbstractEntryApiModel