package ru.roguelike.logic

import ru.roguelike.model.Coordinates

/**
 * Strategy that specifies algorithm according to which our enemy moves
 */
interface CharacterStrategy {
    fun move(enemyCoord: Coordinates, heroCoord: Coordinates): Coordinates
}
