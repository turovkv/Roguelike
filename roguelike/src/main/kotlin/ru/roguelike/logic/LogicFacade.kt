package ru.roguelike.logic

class LogicFacade(
    private val map: MapLogic,
    private val instructions: InstructionsLogic,
    private var current: Logic = map,
) {

    /**
     * process Left Arrow
     */
    fun processLeftArrow() = current.processLeftArrow()

    /**
     * process Right Arrow
     */
    fun processRightArrow() = current.processRightArrow()

    /**
     * process Up Arrow
     */
    fun processUpArrow() = current.processUpArrow()

    /**
     * process Down Arrow
     */
    fun processDownArrow() = current.processDownArrow()

    /**
     * change current logic onto instructions and draw it
     */
    fun processHelp() {
        current = instructions
        current.draw()
    }

    /**
     * change current logic onto map and draw it
     */
    fun processMap() {
        current = map
        current.draw()
    }
}
