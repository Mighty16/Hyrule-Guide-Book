package com.vv.core.domain

interface BaseEntryEntity

data class CreatureEntity(
    val id: Int,
    val category: EntryCategory,
    val commonLocations: List<String>,
    val description: String,
    val imageUrl: String,
    val name: String,
) : BaseEntryEntity

data class MaterialEntity(
    val id: Int,
    val category: EntryCategory,
    val commonLocations: List<String>,
    val description: String,
    val imageUrl: String,
    val name: String,
    val cookingEffect: String,
    val heartsRecovered: Double,
) : BaseEntryEntity

data class EquipmentEntity(
    val id: Int,
    val category: EntryCategory,
    val commonLocations: List<String>,
    val description: String,
    val imageUrl: String,
    val name: String,
    val attack: Int,
    val defense: Int,
) : BaseEntryEntity

data class MonsterEntity(
    val id: Int,
    val category: EntryCategory,
    val commonLocations: List<String>,
    val description: String,
    val imageUrl: String,
    val name: String,
    val drops: List<String>,
) : BaseEntryEntity

data class TreasureEntity(
    val id: Int,
    val category: EntryCategory,
    val commonLocations: List<String>,
    val description: String,
    val imageUrl: String,
    val name: String,
) : BaseEntryEntity