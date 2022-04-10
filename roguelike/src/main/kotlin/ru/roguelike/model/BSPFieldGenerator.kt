package ru.roguelike.model

object BSPFieldGenerator : FieldGenerator {
    override fun generate(): Field {
        return List(17) { List(25) { Cell(CellType.WALKABLE) } }
    }
}
