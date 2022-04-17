package ru.roguelike.logic

import ru.roguelike.model.Coordinates
import ru.roguelike.model.Enemy
import ru.roguelike.model.Hero
import ru.roguelike.model.InventoryModel
import ru.roguelike.model.MapModel
import ru.roguelike.view.MapView
import kotlin.math.max
import kotlin.math.min

/**
 * Class that stores logic about map
 */
class MapLogic(
    private val hero: Hero,
    private val mapModel: MapModel,
    private val inventoryModel: InventoryModel,
    private val view: MapView
) : Logic {
    /**
     * Method that checks whether hero can move to the coordinates
     */
    fun checkCoordinates(c: Coordinates): Boolean {
        return 0 <= c.x && c.x < mapModel.getX() && 0 <= c.y && c.y < mapModel.getY() && mapModel.isWalkable(c) && mapModel.isWithoutEnemy(c)
    }

    /**
     * Method that checks whether the point on map is visible
     */
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

    /**
     * Method that checks whether the hero is visible
     */
    fun isHeroVisible(c: Coordinates) = isVisible(hero.coordinates, c)

    /**
     * Method that updates NPCs positions and statuses
     */
    private fun updateNPCs() {
        val enemies = mutableListOf<Enemy?>()

        for (row in mapModel.field) {
            for (cell in row) {
                cell.enemy?.let { enemy: Enemy ->
                    val oldCoordinates = enemy.coordinates
                    val newCoordinates = enemy.move(this, hero.coordinates)
                    if (oldCoordinates != newCoordinates) {
                        enemies.add(cell.enemy)
                        mapModel.field[oldCoordinates.y][oldCoordinates.x].enemy = null
                    }
                }
            }
        }

        for (enemy in enemies) {
            enemy?.let { enemy: Enemy ->
                val coordinates = enemy.coordinates
                mapModel.field[coordinates.y][coordinates.x].enemy = enemy
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
        mapModel.field[hero.coordinates.y][hero.coordinates.x].item?.let {
            inventoryModel.addItem(it)
        }
        mapModel.field[hero.coordinates.y][hero.coordinates.x].item = null
    }

    /**
     * draw current map
     **/
    override fun draw() {
        view.draw()
    }
}
