package ru.roguelike.logic

import ru.roguelike.model.Coordinates

class SneakyStrategy: CharacterStrategy {
    override fun move(coord: Coordinates, mapLogic: MapLogic): Coordinates {
        val vec = mapLogic.visibleDirVectorToHero(coord) ?: return coord

        val dxdy = listOf(
            Coordinates(vec.x, 0),
            Coordinates(0, vec.y)
        ).filter { it != Coordinates(0, 0) }.random()

        return Coordinates(coord.x - dxdy.x, coord.y - dxdy.y)
    }
}
