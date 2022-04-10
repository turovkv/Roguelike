package ru.roguelike.view

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.screen.Screen
import ru.roguelike.model.CellType
import ru.roguelike.model.Character

class CharacterView(
    private val character: Character,
    private val screen: Screen
) : Drawable {
    override fun draw() {
        screen.setCharacter(
            character.coordinates.y, character.coordinates.x,
            TextCharacter.fromCharacter('*')[0]
        )
        val helth = "HEALTH" + " " + character.hp.toString() + "/" + character.maxHp.toString()
        for (column in helth.indices) {
            for (row in screen.terminalSize.rows - 2 until screen.terminalSize.rows - 1) {
                screen.setCharacter(
                    column, row,
                    TextCharacter.fromCharacter(helth[column])[0]
                )
            }
        }
        val damage = "DAMGE" + " " + character.damage.toString()
        for (column in damage.indices) {
            for (row in screen.terminalSize.rows - 1 until screen.terminalSize.rows) {
                screen.setCharacter(
                    column, row,
                    TextCharacter.fromCharacter(damage[column])[0]
                )
            }
        }
    }
}
