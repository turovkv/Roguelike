package ru.roguelike

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import ru.roguelike.model.MapModel
import ru.roguelike.view.MapView


fun main() {
    val defaultTerminalFactory = DefaultTerminalFactory()
    defaultTerminalFactory.setInitialTerminalSize(TerminalSize(5, 5))
    val terminal = defaultTerminalFactory.createTerminal()
    val screen = TerminalScreen(terminal)
    screen.startScreen()
    screen.cursorPosition = null
    terminal.use {
        while (true) {
            val keyStroke = it.readInput()
            val mapView = MapView(MapModel(), screen)
            mapView.draw()
        }
    }
}
