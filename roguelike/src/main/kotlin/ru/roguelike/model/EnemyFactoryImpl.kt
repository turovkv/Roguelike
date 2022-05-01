package ru.roguelike.model

class EnemyFactoryImpl : EnemyFactory {
    override fun createDragon(x: Int, y: Int): Enemy {
        return Enemy.createRandomEnemy(x, y, EnemyStyle.DRAGON)
    }

    override fun createSkeleton(x: Int, y: Int): Enemy {
        return Enemy.createRandomEnemy(x, y, EnemyStyle.SKELETON)
    }

    override fun createCyborg(x: Int, y: Int): Enemy {
        return Enemy.createRandomEnemy(x, y, EnemyStyle.CYBORG)
    }
}
