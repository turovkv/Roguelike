package ru.roguelike.logic

import ru.roguelike.model.Coordinates

@kotlinx.serialization.Serializable
abstract class CharacterStrategy (
    private val mapLogic: MapLogic
) {
    abstract fun move(coord: Coordinates): Coordinates
}