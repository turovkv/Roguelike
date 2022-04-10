package ru.roguelike.logic

import ru.roguelike.model.Character
import ru.roguelike.model.MapModel

class MapLogic (
    private val character: Character,
    val mapModel: MapModel = MapModel()
) : Logic {
    override fun processLeftArrow() {
        character.moveLeft()
    }

    override fun processRightArrow() {
        character.moveRight()
    }

    override fun processUpArrow() {
        character.moveUp()
    }

    override fun processDownArrow() {
        character.moveDown()
    }
}
