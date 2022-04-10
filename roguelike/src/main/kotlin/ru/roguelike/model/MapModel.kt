package ru.roguelike.model

typealias Field = List<List<Cell>>

class MapModel(
    val field: Field = BSPFieldGenerator.generate()
)
