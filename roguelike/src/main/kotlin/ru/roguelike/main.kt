package ru.roguelike

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import ru.roguelike.logic.InputProcessor
import ru.roguelike.logic.InstructionsLogic
import ru.roguelike.logic.LogicFacade
import ru.roguelike.logic.MapLogic
import ru.roguelike.model.*
import ru.roguelike.util.Constants
import ru.roguelike.view.*

fun main() {
    val mapModel = MapModel()
    val defaultTerminalFactory = DefaultTerminalFactory().also {
        it.setInitialTerminalSize(
            TerminalSize(Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT + Constants.CHARACTER_VIEW_HEIGHT + Constants.ERROR_VIEW_HEIGHT)
        )
    }
    val terminal = defaultTerminalFactory.createTerminal()
    val screen = TerminalScreen(terminal).also {
        it.startScreen(); it.cursorPosition = null
    }

    val coordinates = mapModel.getRandomWalkableCoordinates()

    val character = Character(coordinates = coordinates)
    val characterView = CharacterView(character, screen)
    val mapView = MapView(mapModel, screen, characterView)
    val mapLogic = MapLogic(character, mapModel, mapView)

    val instructionsModel = InstructionModel(
        INSTRUCTIONS,
        DESCRIPTION,
        AUTHORS
    )

    val instructionsView = InstructionsView(instructionsModel, screen)
    val instructionsLogic = InstructionsLogic(instructionsView)

    val logicFacade = LogicFacade(map = mapLogic, instructions = instructionsLogic)
    val inputProcessor = InputProcessor(logicFacade)


//    val inventoryView = InventoryView(InventoryModel(listOf(Shield(2), Sword(3), Apple(4))), characterView, screen)

    terminal.use {
        screen.use {
//            inventoryView.draw()
            mapView.draw()
            while (true) {
                val keyStroke = it.readInput()
                val isNotTerminated = inputProcessor.process(keyStroke)
                if (!isNotTerminated) {
                    break
                }
            }
        }
    }
}
