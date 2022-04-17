package ru.roguelike.model

import ru.roguelike.logic.*
import ru.roguelike.view.AGRESSIVE_CHAR
import ru.roguelike.view.PASSIVE_CHAR
import ru.roguelike.view.SNEAKY_CHAR

@kotlinx.serialization.Serializable
class Enemy(
    override var _coordinates: Coordinates,
    private val strategy: CharacterStrategy,
) : Character() {
    fun act(mapLogic: MapLogic, heroCoordinates: Coordinates) {
        if (!mapLogic.isHeroVisible(coordinates)) {
            return
        }

        val newCoordinates = strategy.move(coordinates, heroCoordinates)
    }

    override fun toString(): String {
        if (strategy is AgressiveStrategy) {
            return AGRESSIVE_CHAR.toString()
        }
        if (strategy is SneakyStrategy) {
            return SNEAKY_CHAR.toString()
        }
        if (strategy is PassiveStrategy) {
            return PASSIVE_CHAR.toString()
        }
        return ""
    }

    companion object {
    }
}
