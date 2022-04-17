package ru.roguelike.logic

import ru.roguelike.model.Coordinates
import kotlin.random.Random

class ConfusedCharacterDecorator(
    private val mapLogic: MapLogic,
    private val characterStrategy: CharacterStrategy
) : CharacterStrategy(mapLogic = mapLogic) {
    override fun move(coordinates: Coordinates): Coordinates {
        val possible = arrayOf(
            Coordinates(coordinates.x - 1, coordinates.y),
            Coordinates(coordinates.x, coordinates.y - 1),
            Coordinates(coordinates.x, coordinates.y + 1),
            Coordinates(coordinates.x + 1, coordinates.y),
        )
        return possible[Random.nextInt(possible.size)]
    }
}