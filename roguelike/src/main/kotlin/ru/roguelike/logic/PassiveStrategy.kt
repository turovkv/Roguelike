package ru.roguelike.logic

import ru.roguelike.model.Coordinates

class PassiveStrategy : CharacterStrategy {
    override fun move(enemyCoord: Coordinates, heroCoord: Coordinates): Coordinates {
        return enemyCoord
    }
}
