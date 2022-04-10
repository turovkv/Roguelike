package ru.roguelike.model

data class Coordinates(val x: Int, val y: Int) {
    fun getLeft() = Coordinates(x - 1, y)
    fun getRight() = Coordinates(x + 1, y)
    fun getUp() = Coordinates(x, y - 1)
    fun getDown() = Coordinates(x, y + 1)
}
