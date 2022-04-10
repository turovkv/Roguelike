package ru.roguelike.model

class Character(
    private var coordinates: Coordinates,
    private var hp: Int,
    private val maxHp: Int,
    private var damage: Int
)
