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
        return 0 <= c.x && c.x < mapModel.getX() && 0 <= c.y && c.y < mapModel.getY() && mapModel.isWalkable(c)
    }

    /**
     * process Left Arrow, move character to the adjacent left cell
     */
    override fun processLeftArrow() {
        if (!checkCoordinates(character.coordinates.getLeft())) {
            return
        }
        character.moveLeft()
        view.draw()
    }

    /**
     * process Right Arrow, move character to the adjacent Right cell
     **/
    override fun processRightArrow() {
        if (!checkCoordinates(character.coordinates.getRight())) {
            return
        }
        character.moveRight()
        view.draw()
    }

    /**
     * process Up Arrow, move character to the adjacent Up cell
     **/
    override fun processUpArrow() {
        if (!checkCoordinates(character.coordinates.getUp())) {
            return
        }
        character.moveUp()
        view.draw()
    }

    /**
     * process Down Arrow, move character to the adjacent Down cell
     **/
    override fun processDownArrow() {
        if (!checkCoordinates(character.coordinates.getDown())) {
            return
        }
        character.moveDown()
        view.draw()
    }

    /**
     * draw current map
     **/
    override fun draw() {
        view.draw()
    }
}
