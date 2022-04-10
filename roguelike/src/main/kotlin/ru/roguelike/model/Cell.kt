package ru.roguelike.model

enum class CellType {
    WALKABLE,
    NON_WALKABLE
}

@kotlinx.serialization.Serializable
data class Cell(val cellType: CellType)
