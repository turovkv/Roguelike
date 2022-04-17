package ru.roguelike.model

import ru.roguelike.logic.CharacterStrategy

class Enemy(
    coordinates: Coordinates,
    private val strategy: CharacterStrategy,
) : Character(coordinates = coordinates) {
    fun act() {
        coordinates = strategy.move(coordinates)
    }
}