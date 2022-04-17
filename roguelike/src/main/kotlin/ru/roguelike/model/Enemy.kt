package ru.roguelike.model

import ru.roguelike.logic.CharacterStrategy

@kotlinx.serialization.Serializable
class Enemy(
    override var _coordinates: Coordinates,
    private val strategy: CharacterStrategy,
) : Character() {
    fun act() {
        _coordinates = strategy.move(coordinates)
    }
}