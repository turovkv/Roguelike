package ru.roguelike.model

/**
 * Specify wwhether character can walk on this cell
 */
enum class CellType {
    WALKABLE,
    NON_WALKABLE
}

/**
 * Class that stores information about field cell
 */
@kotlinx.serialization.Serializable
// TODO(): на клетке не больше одного предмета
data class Cell(val cellType: CellType, var item: Item? = null)
