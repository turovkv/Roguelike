package ru.roguelike.logic

import ru.roguelike.view.InstructionsView

/**
 * Class that stores logic about instructions
 */
class InstructionsLogic(
    private val view: InstructionsView
) : Logic {
    /**
     * draw help
     **/
    override fun draw() {
        view.draw()
    }
}
