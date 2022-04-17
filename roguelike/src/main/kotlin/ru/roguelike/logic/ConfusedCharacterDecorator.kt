package ru.roguelike.logic

import ru.roguelike.model.Coordinates
import kotlin.random.Random

class ConfusedCharacterDecorator(
    private val characterStrategy: CharacterStrategy
) : CharacterStrategy {
    override fun move(coord: Coordinates, mapLogic: MapLogic): Coordinates {
        val possible = arrayOf(
            Coordinates(coord.x - 1, coord.y),
            Coordinates(coord.x, coord.y - 1),
            Coordinates(coord.x, coord.y + 1),
            Coordinates(coord.x + 1, coord.y),
        )
        return possible[Random.nextInt(possible.size)]
    }
}
