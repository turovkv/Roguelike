package ru.roguelike.logic

import ru.roguelike.view.InstructionsView

class InstructionsLogic(
    private val view: InstructionsView
) : Logic {
    override fun processLeftArrow() {
        return
    }

    override fun processRightArrow() {
        return
    }

    override fun processUpArrow() {
        return
    }

    override fun processDownArrow() {
        return
    }

    override fun draw() {
        view.draw()
    }
}
