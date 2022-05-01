package ru.roguelike.model

interface EnemyFactory {
    fun createDragon(): Enemy
    fun createSkelet(): Enemy
    fun createCyborg(): Enemy
}