package ru.roguelike.logic

import ru.roguelike.view.InstructionsView

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
