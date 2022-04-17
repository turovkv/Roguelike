package ru.roguelike.logic

import ru.roguelike.model.Coordinates

class ConfusedCharacterDecorator(
    private val characterStrategy: CharacterStrategy
) : CharacterStrategy {
    override fun move(coordinates: Coordinates): Coordinates {
        TODO("Not yet implemented")
    }
}