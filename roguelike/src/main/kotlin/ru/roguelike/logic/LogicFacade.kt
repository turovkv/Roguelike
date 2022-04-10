package ru.roguelike.logic

class LogicFacade(
    private val map: MapLogic = MapLogic(),
    private val instructions: InstructionsLogic = InstructionsLogic()
) {
    var current: Logic = map
}
