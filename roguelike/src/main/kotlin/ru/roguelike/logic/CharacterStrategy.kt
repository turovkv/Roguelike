package ru.roguelike.logic

import ru.roguelike.model.Coordinates

interface CharacterStrategy {
    fun move(enemyCoord: Coordinates, heroCoord: Coordinates): Coordinates
}
