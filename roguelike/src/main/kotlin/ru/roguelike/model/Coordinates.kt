package ru.roguelike.model

import kotlin.random.Random

/**
 * Class that store coordinates and support operations with them
 */
@kotlinx.serialization.Serializable
data class Coordinates(private var _x: Int, private var _y: Int) {
    val x get() = _x
    val y get() = _y
    fun getLeft() = Coordinates(x - 1, y)
    fun getRight() = Coordinates(x + 1, y)
    fun getUp() = Coordinates(x, y - 1)
    fun getDown() = Coordinates(x, y + 1)

    operator fun plus(other: Coordinates): Coordinates {
        return Coordinates(x + other.x, y + other.y)
    }

    fun swapX(other: Coordinates) {
        _x = other._x.also { other._x = _x }
    }

    fun swapY(other: Coordinates) {
        _y = other._y.also { other._y = _y }
    }

    companion object {
        fun createRandomCoordinates(x: Int, y: Int, width: Int, height: Int): Coordinates {
            return Coordinates(x + Random.nextInt(width), y + Random.nextInt(height))
        }
    }
}
