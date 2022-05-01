package ru.roguelike.model

/**
 * simple implementation of EnemyFactory
 * */
class EnemyFactoryImpl : EnemyFactory {
    /**
     * create dragon :)
     * */
    override fun createDragon(x: Int, y: Int): Enemy {
        return Enemy.createRandomEnemy(x, y, EnemyStyle.DRAGON)
    }

    /**
     * create skeleton :)
     * */
    override fun createSkeleton(x: Int, y: Int): Enemy {
        return Enemy.createRandomEnemy(x, y, EnemyStyle.SKELETON)
    }

    /**
     * create cyborg :)
     * */
    override fun createCyborg(x: Int, y: Int): Enemy {
        return Enemy.createRandomEnemy(x, y, EnemyStyle.CYBORG)
    }
}
