package ru.roguelike.model

typealias Field = List<List<Cell>>

class MapModel(
    private val field: Field = BSPFieldGenerator.generate()
)
