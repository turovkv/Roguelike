package ru.roguelike.model

class Character() {
    var coordinates: Coordinates = Coordinates(0, 0)
        private set
    var damage: Int = 100
        private set
    var hp: Int = 100
        private set
    val maxHp: Int = 100

    fun moveRight() {
        coordinates = Coordinates(coordinates.x + 1, coordinates.y)
    }

    fun moveLeft() {
        coordinates = Coordinates(coordinates.x - 1, coordinates.y)
    }

    fun moveUp() {
        coordinates = Coordinates(coordinates.x, coordinates.y + 1)
    }

    fun moveDown() {
        coordinates = Coordinates(coordinates.x, coordinates.y - 1)
    }
}
