package ru.roguelike.logic

import ru.roguelike.model.Coordinates

class ConfusedCharacterDecorator(
    private val mapLogic: MapLogic,
    private val characterStrategy: CharacterStrategy
) : CharacterStrategy(mapLogic = mapLogic) {
    override fun move(coordinates: Coordinates): Coordinates {
        TODO("Not yet implemented")
    }
}