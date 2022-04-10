package ru.roguelike.logic

interface Logic {
    fun processLeftArrow()
    fun processRightArrow()
    fun processUpArrow()
    fun processDownArrow()
    fun draw()
}
