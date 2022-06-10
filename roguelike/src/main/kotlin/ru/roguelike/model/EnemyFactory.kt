package ru.roguelike.model

import ru.roguelike.util.Constants.CYBORG_PROBABILITY
import ru.roguelike.util.Constants.DRAGON_PROBABILITY
import ru.roguelike.util.Constants.SKELETON_PROBABILITY

/**
 * Interface for creating enemies
 * */
interface EnemyFactory {
    fun create(x: Int, y: Int): Enemy
}
