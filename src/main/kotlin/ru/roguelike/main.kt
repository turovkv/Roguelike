package ru.roguelike

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import ru.roguelike.command.CommandFactory
import ru.roguelike.logic.GameState
import ru.roguelike.logic.InstructionsLogic
import ru.roguelike.logic.InventoryLogic
import ru.roguelike.logic.LogicFacade
import ru.roguelike.logic.MapLogic
import ru.roguelike.model.Hero
import ru.roguelike.model.InstructionModel
import ru.roguelike.model.InventoryModel
import ru.roguelike.model.MapModel
import ru.roguelike.model.RandomEnemyFactory
import ru.roguelike.model.generator.FieldBuilder
import ru.roguelike.util.Constants
import ru.roguelike.view.AUTHORS
import ru.roguelike.view.CharacterView
import ru.roguelike.view.DESCRIPTION
import ru.roguelike.view.INSTRUCTIONS
import ru.roguelike.view.InstructionsView
import ru.roguelike.view.InventoryView
import ru.roguelike.view.MapView
import java.io.FileInputStream
import java.util.Properties

fun main() {
    val defaultTerminalFactory = DefaultTerminalFactory().also {
        it.setInitialTerminalSize(
            TerminalSize(
                Constants.FIELD_WIDTH,
                Constants.FIELD_HEIGHT + Constants.CHARACTER_VIEW_HEIGHT + Constants.ERROR_VIEW_HEIGHT
            )
        )
    }
    val terminal = defaultTerminalFactory.createTerminal()
    val screen = TerminalScreen(terminal).also {
        it.startScreen(); it.cursorPosition = null
    }

    terminal.use {
        screen.use {
            mainLoop@ while (true) {
                val logicFacade = getLogicFacade(screen)
                while (true) {
                    val keyStroke = it.readInput()
                    val command = CommandFactory.getCommand(keyStroke, logicFacade)
                    when (command.execute()) {
                        GameState.GOOD -> continue
                        GameState.DEAD_HERO -> break
                        GameState.TERMINATED -> break@mainLoop
                    }
                }
            }
        }
    }
}

private fun getLogicFacade(screen: TerminalScreen): LogicFacade {
    val field = FieldBuilder(RandomEnemyFactory())
        .withProperties(Properties().also { it.load(FileInputStream("src/main/resources/map.properties")) })
        .build()

    val mapModel = MapModel(field)
    val inventoryModel = InventoryModel()
    val coordinates = mapModel.getRandomWalkableCoordinates()
    val hero = Hero(_coordinates = coordinates)
    val characterView = CharacterView(hero, screen)
    val mapView = MapView(mapModel, screen, characterView)
    val mapLogic = MapLogic(hero, mapModel, inventoryModel, mapView)
    val inventoryView = InventoryView(inventoryModel, characterView, screen)
    val inventoryLogic = InventoryLogic(hero, inventoryModel, mapModel, inventoryView)
    val instructionsModel = InstructionModel(INSTRUCTIONS, DESCRIPTION, AUTHORS)
    val instructionsView = InstructionsView(instructionsModel, screen)
    val instructionsLogic = InstructionsLogic(instructionsView)
    val logicFacade = LogicFacade(map = mapLogic, instructions = instructionsLogic, inventoryLogic)

    mapView.draw()
    return logicFacade
}
