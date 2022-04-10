package ru.roguelike.logic

class LogicFacade(
    private val character: ru.roguelike.model.Character,
    private val map: MapLogic = MapLogic(character),
    private val instructions: InstructionsLogic = InstructionsLogic(),
    private var curent: Logic = map,
) {
    fun processLeftArrow() = curent.processLeftArrow()
    fun processRightArrow() = curent.processRightArrow()
    fun processUpArrow() = curent.processUpArrow()
    fun processDownArrow() = curent.processDownArrow()
}
