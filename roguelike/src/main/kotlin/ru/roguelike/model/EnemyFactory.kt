package ru.roguelike.model

import ru.roguelike.util.Constants.CYBORG_PROBABILITY
import ru.roguelike.util.Constants.DRAGON_PROBABILITY
import ru.roguelike.util.Constants.SKELETON_PROBABILITY

/**
 * EnemyFactory which can create dragons, skeletons, cyborgs
 * */
interface EnemyFactory {
    /**
     * create dragon :)
     * */
    fun createDragon(x: Int, y: Int): Enemy
    /**
     * create skeleton :)
     * */
    fun createSkeleton(x: Int, y: Int): Enemy
    /**
     * create cyborg :)
     * */
    fun createCyborg(x: Int, y: Int): Enemy

    /**
     * create cyborg or skeleton or dragon randomly :)
     * */
    fun createRandomEnemy(x: Int, y: Int): Enemy {
        val indList = mutableListOf<Int>()
        repeat((100 * DRAGON_PROBABILITY).toInt()) {
            indList.add(EnemyStyle.DRAGON.ordinal)
        }
        repeat((100 * SKELETON_PROBABILITY).toInt()) {
            indList.add(EnemyStyle.SKELETON.ordinal)
        }
        repeat((100 * CYBORG_PROBABILITY).toInt()) {
            indList.add(EnemyStyle.CYBORG.ordinal)
        }
        return when (EnemyStyle.values()[indList.random()]) {
            EnemyStyle.DRAGON -> createDragon(x, y)
            EnemyStyle.SKELETON -> createSkeleton(x, y)
            EnemyStyle.CYBORG -> createCyborg(x, y)
        }
    }
}
