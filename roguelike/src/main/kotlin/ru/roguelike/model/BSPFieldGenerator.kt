package ru.roguelike.model

object BSPFieldGenerator : FieldGenerator {
    override fun generate(): Field {
        return List(60) { List(30) { Cell(CellType.WALKABLE) } }
    }
}
