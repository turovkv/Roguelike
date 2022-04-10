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
