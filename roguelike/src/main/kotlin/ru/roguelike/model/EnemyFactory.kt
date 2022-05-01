package ru.roguelike.model

interface EnemyFactory {
    fun createDragon(x: Int, y: Int): Enemy
    fun createSkeleton(x: Int, y: Int): Enemy
    fun createCyborg(x: Int, y: Int): Enemy
}
