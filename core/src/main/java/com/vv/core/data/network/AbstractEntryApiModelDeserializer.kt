package com.vv.core.data.network

import com.vv.core.data.network.api_models.AbstractEntryApiModel
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.lang.IllegalArgumentException

object AbstractEntryApiModelDeserializer : JsonTransformingSerializer<AbstractEntryApiModel>(
    PolymorphicSerializer(AbstractEntryApiModel::class)
) {

    override fun transformDeserialize(element: JsonElement): JsonElement {
        val categoryJsonValue = element.jsonObject["category"]
            ?: throw IllegalArgumentException("'category' param was not found while parsing entry")
        val categoryValue =
            categoryJsonValue.jsonPrimitive.toString()

        return JsonObject(
            element.jsonObject.toMutableMap()
            .also {
                it["type"] = JsonPrimitive(categoryValue)
            })
    }

}