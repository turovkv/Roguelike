package ru.roguelike.logic

import ru.roguelike.model.Coordinates

abstract class CharacterStrategy (
    private val mapLogic: MapLogic
) {
    abstract fun move(coordinates: Coordinates): Coordinates
}