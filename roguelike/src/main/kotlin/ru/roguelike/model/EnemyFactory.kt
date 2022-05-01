package ru.roguelike.model

/**
 * EnemyFactory which can create dragons, skeletons, cyborgs
 * */
interface EnemyFactory {
    fun createDragon(x: Int, y: Int): Enemy
    fun createSkeleton(x: Int, y: Int): Enemy
    fun createCyborg(x: Int, y: Int): Enemy

    fun createRandomEnemy(x: Int, y: Int): Enemy =
        when (EnemyStyle.values().random()) {
            EnemyStyle.DRAGON -> createDragon(x, y)
            EnemyStyle.SKELETON -> createSkeleton(x, y)
            EnemyStyle.CYBORG -> createCyborg(x, y)
        }
}
