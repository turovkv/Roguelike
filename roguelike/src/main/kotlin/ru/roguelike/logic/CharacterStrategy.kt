package ru.roguelike.logic

import ru.roguelike.model.Coordinates

interface CharacterStrategy {
    fun move(coordinates: Coordinates): Coordinates
}