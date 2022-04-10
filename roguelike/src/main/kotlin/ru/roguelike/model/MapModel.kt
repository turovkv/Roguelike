package ru.roguelike.model

typealias Field = List<List<Cell>>

class MapModel(
    val field: Field = BSPFieldGenerator.generate()
) {
    fun getX() = field[0].size
    fun getY() = field.size
}
