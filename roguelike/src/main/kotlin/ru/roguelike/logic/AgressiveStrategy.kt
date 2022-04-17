package ru.roguelike.logic

import ru.roguelike.model.Coordinates

class AgressiveStrategy(
    private val mapLogic: MapLogic,
) : CharacterStrategy(mapLogic = mapLogic) {
    override fun move(coordinates: Coordinates): Coordinates {
        TODO("Not yet implemented")
    }
}