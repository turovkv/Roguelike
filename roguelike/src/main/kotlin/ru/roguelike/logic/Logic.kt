package ru.roguelike.logic

interface Logic {
    /**
     * process Left Arrow
     */
    fun processLeftArrow()

    /**
     * process Right Arrow
     **/
    fun processRightArrow()

    /**
     * process Up Arrow
     **/
    fun processUpArrow()

    /**
     * process Down Arrow
     **/
    fun processDownArrow()

    /**
     * draw current logic
     **/
    fun draw()
}
