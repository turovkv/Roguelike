package ru.roguelike.model

class Character() {
    var coordinates: Coordinates = Coordinates(10, 10)
        private set
    var damage: Int = 5
        private set
    var hp: Int = 2
        private set
    val maxHp: Int = 5

    fun moveRight() {
        coordinates = coordinates.getRight()
    }

    fun moveLeft() {
        coordinates = coordinates.getLeft()
    }

    fun moveUp() {
        coordinates = coordinates.getUp()
    }

    fun moveDown() {
        coordinates = coordinates.getDown()
    }
}
