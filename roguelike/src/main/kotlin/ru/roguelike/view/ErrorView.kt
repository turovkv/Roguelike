package ru.roguelike.view

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.screen.Screen

/**
 * This class provides one method which draws error.
 */
class ErrorView(
    private val error: String,
    private val screen: Screen
) : Drawable {
    /**
     * This method draws error.
     */
    override fun draw() {
        for ((index, symbol) in error.withIndex())
        screen.setCharacter(
            index, 0,
            TextCharacter.fromCharacter(symbol)[0]
        )
    }
}