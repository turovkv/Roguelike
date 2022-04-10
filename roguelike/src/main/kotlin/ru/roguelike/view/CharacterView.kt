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
        for (column in 0 until character.maxHp) {
            for (row in 0 until 1) {
                screen.setCharacter(
                    column, row,
                    TextCharacter.fromCharacter('_')[0]
                )
            }
        }
        for (column in 0 until character.hp) {
            for (row in 0 until 1) {
                screen.setCharacter(
                    column, row,
                    TextCharacter.fromCharacter('\\')[0]
                )
            }
        }
        screen.setCharacter(
            character.maxHp, 0,
            TextCharacter.fromCharacter((character.hp + '0'.code).toChar())[0]
        )
        screen.setCharacter(
            character.maxHp + 1, 0,
            TextCharacter.fromCharacter('/')[0]
        )
        screen.setCharacter(
            character.maxHp + 2, 0,
            TextCharacter.fromCharacter((character.maxHp + '0'.code).toChar())[0]
        )
        for (column in 0 until character.damage) {
            for (row in 1 until 2) {
                screen.setCharacter(
                    column, row,
                    TextCharacter.fromCharacter('/')[0]
                )
            }
        }
        screen.setCharacter(
            character.damage, 1,
            TextCharacter.fromCharacter((character.damage + '0'.code).toChar())[0]
        )
    }
}
