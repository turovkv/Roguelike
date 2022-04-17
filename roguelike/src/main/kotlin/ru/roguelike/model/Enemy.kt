package ru.roguelike.model

import ru.roguelike.logic.AgressiveStrategy
import ru.roguelike.logic.CharacterStrategy
import ru.roguelike.logic.PassiveStrategy
import ru.roguelike.logic.SneakyStrategy
import ru.roguelike.view.AGRESSIVE_CHAR
import ru.roguelike.view.PASSIVE_CHAR
import ru.roguelike.view.SNEAKY_CHAR

@kotlinx.serialization.Serializable
class Enemy(
    override var _coordinates: Coordinates,
    private val strategy: CharacterStrategy,
) : Character() {
    fun act() {
        _coordinates = strategy.move(coordinates)
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
}
