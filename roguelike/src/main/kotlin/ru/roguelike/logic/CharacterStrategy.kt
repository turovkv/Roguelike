package ru.roguelike.logic

import ru.roguelike.model.Coordinates

interface CharacterStrategy {
    fun move(coord: Coordinates, mapLogic: MapLogic): Coordinates
}
