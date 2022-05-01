package ru.roguelike.model

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
    fun createRandomEnemy(x: Int, y: Int): Enemy =
        when (EnemyStyle.values().random()) {
            EnemyStyle.DRAGON -> createDragon(x, y)
            EnemyStyle.SKELETON -> createSkeleton(x, y)
            EnemyStyle.CYBORG -> createCyborg(x, y)
        }
}
