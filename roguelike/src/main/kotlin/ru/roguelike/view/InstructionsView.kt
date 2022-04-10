package ru.roguelike.view

import com.googlecode.lanterna.screen.Screen
import ru.roguelike.model.InstructionModel

class InstructionsView(
    private val instructions: InstructionModel,
    private val screen: Screen
) : Drawable {
    override fun draw() {

    }
}
