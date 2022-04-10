package ru.roguelike

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import ru.roguelike.model.Character
import ru.roguelike.model.Coordinates
import ru.roguelike.model.MapModel
import ru.roguelike.view.CharacterView
import ru.roguelike.view.MapView


fun main() {
    val mapModel = MapModel()
    val defaultTerminalFactory = DefaultTerminalFactory()
    defaultTerminalFactory.setInitialTerminalSize(TerminalSize(mapModel.field.size, mapModel.field[0].size))
    val terminal = defaultTerminalFactory.createTerminal()
    val screen = TerminalScreen(terminal)
    screen.startScreen()
    screen.cursorPosition = null
    val mapView = MapView(mapModel, screen)
    val characterView = CharacterView(Character(), screen)
    terminal.use {
        screen.use {
            while (true) {
                mapView.draw()
                characterView.draw()
                screen.refresh()
                val keyStroke = it.readInput()
            }
        }
    }
}
