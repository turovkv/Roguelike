package ru.roguelike.logic

class LogicFacade(
    private val map: MapLogic,
    private val instructions: InstructionsLogic,
    private var current: Logic = map,
) {
    fun processLeftArrow() = current.processLeftArrow()
    fun processRightArrow() = current.processRightArrow()
    fun processUpArrow() = current.processUpArrow()
    fun processDownArrow() = current.processDownArrow()
    fun processHelp() {
        current = instructions
        current.draw()
    }

    fun processMap() {
        current = map
        current.draw()
    }
}
