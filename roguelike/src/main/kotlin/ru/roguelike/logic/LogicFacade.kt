package ru.roguelike.logic

import com.googlecode.lanterna.screen.Screen
import ru.roguelike.model.Character

class LogicFacade(
    private val character: Character,
    private val map: MapLogic,
    private val instructions: InstructionsLogic,
    private var current: Logic = map,
) {
    fun processLeftArrow() = current.processLeftArrow()
    fun processRightArrow() = current.processRightArrow()
    fun processUpArrow() = current.processUpArrow()
    fun processDownArrow() = current.processDownArrow()
    fun processHelp() { current = instructions }
    fun processMap() { current = map }
}
