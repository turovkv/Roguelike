package ru.roguelike.model

/**
 * Class that stores information about main character
 */
@kotlinx.serialization.Serializable
abstract class Character {
    protected abstract var _coordinates: Coordinates
    val coordinates get() = _coordinates

    var damage: Int = 5
        protected set
    var hp: Int = 2
        protected set
    val maxHp: Int = 5

    /**
     * Move character to one cell right
     */
    fun moveRight() {
        _coordinates = coordinates.getRight()
    }

    /**
     * Move character to one cell left
     */
    fun moveLeft() {
        _coordinates = coordinates.getLeft()
    }

    /**
     * Move character to one cell up
     */
    fun moveUp() {
        _coordinates = coordinates.getUp()
    }

    /**
     * Move character to one cell down
     */
    fun moveDown() {
        _coordinates = coordinates.getDown()
    }
}
