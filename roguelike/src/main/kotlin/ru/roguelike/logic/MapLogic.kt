package ru.roguelike.logic

import ru.roguelike.model.Character
import ru.roguelike.model.Coordinates
import ru.roguelike.model.MapModel
import ru.roguelike.view.Drawable

class MapLogic(
    private val character: Character,
    private val mapModel: MapModel,
    private val view: Drawable
) : Logic {

    private fun checkCoordinates(c: Coordinates): Boolean {
        return 0 <= c.x && c.x < mapModel.getX() && 0 <= c.y && c.y < mapModel.getY()
    }

    override fun processLeftArrow() {
        if (!checkCoordinates(character.coordinates.getUp())) {
            return
        }
        character.moveUp()
        view.draw()
    }

    override fun processRightArrow() {
        if (!checkCoordinates(character.coordinates.getDown())) {
            return
        }
        character.moveDown()
        view.draw()
    }

    override fun processUpArrow() {
        if (!checkCoordinates(character.coordinates.getLeft())) {
            return
        }
        character.moveLeft()
        view.draw()
    }

    override fun processDownArrow() {
        if (!checkCoordinates(character.coordinates.getRight())) {
            return
        }
        character.moveRight()
        view.draw()
    }

    override fun draw() {
        view.draw()
    }
}
