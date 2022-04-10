package ru.roguelike.model

object BSPFieldGenerator : FieldGenerator {
    override fun generate(): Field {
        return List(37) { List(35) { Cell(CellType.WALKABLE) } }
    }
}
