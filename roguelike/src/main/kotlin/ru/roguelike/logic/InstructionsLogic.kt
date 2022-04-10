package ru.roguelike.logic

import ru.roguelike.view.InstructionsView

class InstructionsLogic(
    private val view: InstructionsView
) : Logic {
    /**
     * process Left Arrow, do nothing
     */
    override fun processLeftArrow() {
        return
    }

    /**
     * process Right Arrow, do nothing
     **/
    override fun processRightArrow() {
        return
    }

    /**
     * process Up Arrow, do nothing
     **/
    override fun processUpArrow() {
        return
    }

    /**
     * process Down Arrow, do nothing
     **/
    override fun processDownArrow() {
        return
    }

    /**
     * draw help
     **/
    override fun draw() {
        view.draw()
    }
}
