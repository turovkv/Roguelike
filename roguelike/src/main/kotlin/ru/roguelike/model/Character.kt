package ru.roguelike.model

import kotlin.math.min

/**
 * Class that stores information about characters
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
    var armor: Int = 0
        protected set
    abstract val exp: Int

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

    /**
     * Attack another character
     */
    open fun attackedBy(character: Character) {
        val damageToArmor = min(armor, character.damage)
        armor -= damageToArmor
        hp -= damage - damageToArmor
    }

    companion object {
        fun duel(ch1: Character, ch2: Character) {
            ch1.attackedBy(ch2)
            ch2.attackedBy(ch1)
        }
    }

    /**
     * Check whether we dead or not
     */
    fun isDead(): Boolean = hp <= 0
}
