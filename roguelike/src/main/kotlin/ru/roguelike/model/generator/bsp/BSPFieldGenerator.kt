package ru.roguelike.model.generator.bsp

import ru.roguelike.model.Cell
import ru.roguelike.model.CellType
import ru.roguelike.model.Field
import ru.roguelike.model.generator.FieldGenerator
import ru.roguelike.util.Constants

object BSPFieldGenerator : FieldGenerator {
    override fun generate(): Field {
        val field = MutableList(Constants.FIELD_HEIGHT) {
            MutableList(Constants.FIELD_WIDTH) { Cell(CellType.NON_WALKABLE) }
        }
        val root = Leaf(0, 0, Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT)
        root.split()
        root.createRooms()
        root.fillField(field)

        return field
    }
}