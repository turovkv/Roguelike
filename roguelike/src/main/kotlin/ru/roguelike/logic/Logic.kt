package ru.roguelike.logic

/**
 * All processing operations do nothing by default
 */
interface Logic {
    /**
     * process moving left
     */
    fun moveLeft() {}

    /**
     * process moving right
     **/
    fun moveRight() {}

    /**
     * process moving up
     **/
    fun moveUp() {}

    /**
     * process moving down
     **/
    fun moveDown() {}

    fun processDrop() {}

    fun processEquip() {}

    fun processUnEquip() {}
    /**
     * draw current logic
     **/
    fun draw()
}
