package ru.roguelike.logic

import ru.roguelike.model.Coordinates

class PassiveStrategy : CharacterStrategy {
    override fun move(coord: Coordinates, mapLogic: MapLogic): Coordinates {
        return coord
    }
}
