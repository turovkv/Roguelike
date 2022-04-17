package ru.roguelike.logic

import ru.roguelike.model.Coordinates

class SneakyStrategy(
    private val mapLogic: MapLogic,
) : CharacterStrategy(mapLogic = mapLogic) {
    override fun move(coord: Coordinates): Coordinates {
        if (!mapLogic.isHeroVisible(coord)) {
            return coord
        }
        val vec = mapLogic.directionVectorToHero(coord)
        if (vec == Coordinates(0, 0)) {
            return coord;
        }

        val dxdy = listOf(
            Coordinates(vec.x, 0),
            Coordinates(0, vec.y)
        ).filter { it != Coordinates(0, 0) }.random()

        return Coordinates(coord.x - dxdy.x, coord.y - dxdy.y)
    }
}
