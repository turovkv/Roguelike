package ru.roguelike

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import ru.roguelike.logic.InputProcessor
import ru.roguelike.logic.InstructionsLogic
import ru.roguelike.logic.LogicFacade
import ru.roguelike.logic.MapLogic
import ru.roguelike.model.Character
import ru.roguelike.model.Coordinates
import ru.roguelike.model.MapModel
import ru.roguelike.view.CharacterView
import ru.roguelike.view.MapView


fun main() {
    val mapModel = MapModel()
    val defaultTerminalFactory = DefaultTerminalFactory()
    defaultTerminalFactory.setInitialTerminalSize(TerminalSize(mapModel.field.size, mapModel.field[0].size + 2))
    val terminal = defaultTerminalFactory.createTerminal()
    val screen = TerminalScreen(terminal)
    screen.startScreen()
    screen.cursorPosition = null
    val mapView = MapView(mapModel, screen)
    val characterView = CharacterView(Character(), screen)

    val character = Character()

    val mapLogic = MapLogic(character = character, view = mapView)
    val instructionsLogic = InstructionsLogic()

    val logicFacade = LogicFacade(map = mapLogic, instructions = instructionsLogic)

    val inputProcessor = InputProcessor(logicFacade)

    terminal.use {
        screen.use {
            while (true) {
                mapView.draw()
                characterView.draw()
                screen.refresh()
                val keyStroke = it.readInput()
                inputProcessor.process(keyStroke)
            }
        }
    }
}
