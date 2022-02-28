package com.vv.core.data.network

import com.vv.core.data.network.api_models.AbstractEntryApiModel
import com.vv.core.data.network.api_models.CreatureApiModel
import com.vv.core.data.network.api_models.EquipmentApiModel
import com.vv.core.data.network.api_models.MaterialApiModel
import com.vv.core.data.network.api_models.MonsterApiModel
import com.vv.core.data.network.api_models.TreasureApiModel
import com.vv.core.domain.BaseEntryEntity
import com.vv.core.domain.CreatureEntity
import com.vv.core.domain.EntryCategory
import com.vv.core.domain.EquipmentEntity
import com.vv.core.domain.MaterialEntity
import com.vv.core.domain.MonsterEntity
import com.vv.core.domain.TreasureEntity


fun AbstractEntryApiModel.toEntity(): BaseEntryEntity? {
    return when (this) {
        is CreatureApiModel -> CreatureEntity(
            id = this.id ?: 0,
            category = EntryCategory.valueOf(this.category ?: "unknown"),
            commonLocations = this.commonLocations ?: emptyList(),
            description = this.description ?: "",
            imageUrl = this.image ?: "",
            name = this.name ?: "",
        )
        is EquipmentApiModel -> EquipmentEntity(
            id = this.id ?: 0,
            category = EntryCategory.valueOf(this.category ?: "unknown"),
            commonLocations = this.commonLocations ?: emptyList(),
            description = this.description ?: "",
            imageUrl = this.image ?: "",
            name = this.name ?: "",
            attack = this.attack ?: 0,
            defense = this.defense ?: 0
        )
        is MaterialApiModel -> MaterialEntity(
            id = this.id ?: 0,
            category = EntryCategory.valueOf(this.category ?: "unknown"),
            commonLocations = this.commonLocations ?: emptyList(),
            description = this.description ?: "",
            imageUrl = this.image ?: "",
            name = this.name ?: "",
            cookingEffect = this.cookingEffect ?: "",
            heartsRecovered = this.heartsRecovered ?: 0.0
        )
        is MonsterApiModel -> MonsterEntity(
            id = this.id ?: 0,
            category = EntryCategory.valueOf(this.category ?: "unknown"),
            commonLocations = this.commonLocations ?: emptyList(),
            description = this.description ?: "",
            imageUrl = this.image ?: "",
            name = this.name ?: "",
            drops = this.drops?: emptyList()
        )
        is TreasureApiModel -> TreasureEntity(
            id = this.id ?: 0,
            category = EntryCategory.valueOf(this.category ?: "unknown"),
            commonLocations = this.commonLocations ?: emptyList(),
            description = this.description ?: "",
            imageUrl = this.image ?: "",
            name = this.name ?: "",
        )
        else -> null
    }
}
