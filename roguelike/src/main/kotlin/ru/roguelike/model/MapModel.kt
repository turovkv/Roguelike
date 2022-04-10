package ru.roguelike.model

typealias Field = List<List<Cell>>

class MapModel(
    val field: Field = BSPFieldGenerator.generate()
) {
    fun getX() = field.size
    fun getY() = field[0].size
}
