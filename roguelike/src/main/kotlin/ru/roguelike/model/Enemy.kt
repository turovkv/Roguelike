package ru.roguelike.model

import ru.roguelike.logic.*
import ru.roguelike.util.Constants
import ru.roguelike.view.AGRESSIVE_CHAR
import ru.roguelike.view.PASSIVE_CHAR
import ru.roguelike.view.SNEAKY_CHAR
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Class that store information about enemy
 */
@kotlinx.serialization.Serializable
class Enemy(
    override var _coordinates: Coordinates,
    private val strategy: CharacterStrategy,
) : Character() {
    /**
     * Move
     */
    fun move(mapLogic: MapLogic, heroCoordinates: Coordinates): Coordinates {
        if (!mapLogic.isHeroVisible(coordinates)) {
            return coordinates
        }

        val newCoordinates = strategy.move(coordinates, heroCoordinates)

        if (mapLogic.checkCoordinates(newCoordinates)) {
            return newCoordinates
        }
        return coordinates
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
        private val strategies = listOf(AgressiveStrategy(), SneakyStrategy(), PassiveStrategy())

        fun createRandomEnemy(x: Int, y: Int): Enemy {
            val enemy = Enemy(Coordinates(x, y), strategies.random())
            enemy.hp = Random.nextInt(1..Constants.MAX_HP)
            enemy.damage = Random.nextInt(1..Constants.MAX_DAMAGE)

            return enemy
        }
    }
}
