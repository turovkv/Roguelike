package ru.roguelike.logic

class LogicFacade(
    private val map: MapLogic,
    private val instructions: InstructionsLogic,
    private var current: Logic = map,
) {

    /*
    * обработка движения влево
    * */
    fun processLeftArrow() = current.processLeftArrow()

    /*
    * обработка движения вправо
    * */
    fun processRightArrow() = current.processRightArrow()

    /*
    * обработка движения вверх
    * */
    fun processUpArrow() = current.processUpArrow()

    /*
    * обработка движения вниз
    * */
    fun processDownArrow() = current.processDownArrow()

    /*
    * сменить текущую логику на instructions и нарисовать ее
    * */
    fun processHelp() {
        current = instructions
        current.draw()
    }

    /*
    * сменить текущую логику на map и нарисовать ее
    * */
    fun processMap() {
        current = map
        current.draw()
    }
}
