package ru.roguelike.model

import ru.roguelike.util.Constants.CYBORG_PROBABILITY
import ru.roguelike.util.Constants.DRAGON_PROBABILITY
import ru.roguelike.util.Constants.SKELETON_PROBABILITY

class RandomEnemyFactory : EnemyFactory {
    override fun create(x: Int, y: Int): Enemy {
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
            EnemyStyle.DRAGON -> DragonFactory().create(x, y)
            EnemyStyle.SKELETON -> SkeletonFactory().create(x, y)
            EnemyStyle.CYBORG -> CyborgFactory().create(x, y)
        }
    }
}