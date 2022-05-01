package ru.roguelike.model

interface EnemyFactory {
    fun createDragon(x: Int, y: Int): Enemy
    fun createSkelet(x: Int, y: Int): Enemy
    fun createCyborg(x: Int, y: Int): Enemy
}