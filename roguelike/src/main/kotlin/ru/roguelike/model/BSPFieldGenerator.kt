package ru.roguelike.model

object BSPFieldGenerator : FieldGenerator {
    override fun generate(): Field {
        return List(7) { List(5) { Cell(CellType.WALKABLE) } }
    }
}
