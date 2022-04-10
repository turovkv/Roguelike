package ru.roguelike.view

import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.Terminal
import ru.roguelike.model.CellType
import ru.roguelike.model.MapModel

class MapView(
    private val map: MapModel,
    private val screen: Screen
) : Drawable {
    override fun draw() {
        val terminalSize: TerminalSize = screen.terminalSize
        for (column in 0 until terminalSize.columns) {
            for (row in 0 until terminalSize.rows) {
                screen.setCharacter(
                    column, row,
                    when (map.field[column][row].cellType) {
                        CellType.WALKABLE -> TextCharacter.fromCharacter('.')[0]
                        CellType.NON_WALKABLE -> TextCharacter.fromCharacter('#')[0]
                    }
                )
            }
        }
        screen.refresh()
    }
}