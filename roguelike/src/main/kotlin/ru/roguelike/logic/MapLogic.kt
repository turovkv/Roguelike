package ru.roguelike.logic

import ru.roguelike.model.*
import ru.roguelike.view.MapView
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sign

@kotlinx.serialization.Serializable
class MapLogic(
    private val hero: Hero,
    private val mapModel: MapModel,
    private val inventoryModel: InventoryModel,
    private val view: MapView
) : Logic {

    fun checkCoordinates(c: Coordinates): Boolean {
        return 0 <= c.x && c.x < mapModel.getX() && 0 <= c.y && c.y < mapModel.getY() && mapModel.isWalkable(c)
    }

    private fun isVisible(c1: Coordinates, c2: Coordinates): Boolean {
        if (c1 == c2) {
            return true
        }

        if (c1.x == c2.x) {
            for (y in min(c1.y, c2.y)..max(c1.y, c2.y)) {
                if (!checkCoordinates(Coordinates(c1.x, y))) {
                    return false
                }
            }
            return true
        }

        if (c1.y == c2.y) {
            for (x in min(c1.x, c2.x)..max(c1.x, c2.x)) {
                if (!checkCoordinates(Coordinates(x, c1.y))) {
                    return false
                }
            }
            return true
        }

        // c1.x != c2.x && c1.y != c2.y
        for (x in min(c1.x, c2.x) until max(c1.x, c2.x)) {
            val y = (x - c1.x) * (c2.y - c1.y) * 1.0 / (c2.x - c1.x) + c1.y
            if (!checkCoordinates(Coordinates(x - 1, y.toInt()))) {
                return false
            }
            if (!checkCoordinates(Coordinates(x, y.toInt()))) {
                return false
            }
            if (y.toInt().toDouble() == y) {
                if (!checkCoordinates(Coordinates(x - 1, y.toInt() - 1))) {
                    return false
                }
                if (!checkCoordinates(Coordinates(x, y.toInt() - 1))) {
                    return false
                }
            }
        }

        for (y in min(c1.y, c2.y) until max(c1.y, c2.y)) {
            val x = (y - c1.y) * (c2.x - c1.x) * 1.0 / (c2.y - c1.y) + c1.x
            if (!checkCoordinates(Coordinates(x.toInt(), y - 1))) {
                return false
            }
            if (!checkCoordinates(Coordinates(x.toInt(), y))) {
                return false
            }
            if (x.toInt().toDouble() == x) {
                if (!checkCoordinates(Coordinates(x.toInt() - 1, y - 1))) {
                    return false
                }
                if (!checkCoordinates(Coordinates(x.toInt() - 1, y))) {
                    return false
                }
            }
        }

        return true
    }

    fun isHeroVisible(c: Coordinates) = isVisible(hero.coordinates, c)

    fun visibleDirVectorToHero(c: Coordinates): Coordinates? {
        if (!isHeroVisible(c)) {
            return null
        }

        return Coordinates(
            sign((hero.coordinates.x - c.x).toDouble()).toInt(),
            sign((hero.coordinates.y - c.y).toDouble()).toInt()
        )
    }

    private fun updateNPCs() {
        for (row in mapModel.field) {
            for (cell in row) {
                cell.enemy?.let {
                    enemy: Enemy -> enemy.act(this)
                }
            }
        }
    }

    /**
     * process moving left, move character to the adjacent left cell
     */
    override fun moveLeft() {
        if (!checkCoordinates(hero.coordinates.getLeft())) {
            return
        }
        hero.moveLeft()
        updateNPCs()
    }

    /**
     * process moving right, move character to the adjacent Right cell
     **/
    override fun moveRight() {
        if (!checkCoordinates(hero.coordinates.getRight())) {
            return
        }
        hero.moveRight()
        updateNPCs()
    }

    /**
     * process moving up, move character to the adjacent Up cell
     **/
    override fun moveUp() {
        if (!checkCoordinates(hero.coordinates.getUp())) {
            return
        }
        hero.moveUp()
        updateNPCs()
    }

    /**
     * process moving down, move character to the adjacent Down cell
     **/
    override fun moveDown() {
        if (!checkCoordinates(hero.coordinates.getDown())) {
            return
        }
        hero.moveDown()
        updateNPCs()
    }

    override fun processEquip() {
        mapModel.field[hero.coordinates.x][hero.coordinates.y].item?.let {
            inventoryModel.addItem(it)
        }
        mapModel.field[hero.coordinates.x][hero.coordinates.y].item = null
    }

    /**
     * draw current map
     **/
    override fun draw() {
        view.draw()
    }
}
