package ru.roguelike.model

data class Character(
    var coordinates: Coordinates,
    var hp: Int,
    val maxHp: Int,
    var damage: Int
)
