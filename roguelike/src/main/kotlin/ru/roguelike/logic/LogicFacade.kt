package ru.roguelike.logic

class LogicFacade(
    private val map: MapLogic,
    private val instructions: InstructionsLogic,
    private val inventory: InventoryLogic,
    private var current: Logic = map,
) {
    /**
     * process moving left
     */
    fun moveLeft() {
        current.moveLeft()
        current.draw()
    }

    /**
     * process moving right
     */
    fun moveRight() {
        current.moveRight()
        current.draw()
    }

    /**
     * process moving up
     */
    fun moveUp() {
        current.moveUp()
        current.draw()
    }

    /**
     * process moving down
     */
    fun moveDown() {
        current.moveDown()
        current.draw()
    }

    /**
     * change current logic onto instructions and draw it
     */
    fun processHelp() {
        current = instructions
        current.draw()
    }

    /**
     * change current logic onto map and draw it
     */
    fun processMap() {
        current = map
        current.draw()
    }

    fun processInventory() {
        current = inventory
        current.draw()
    }

    fun processEquip() {
        current.processEquip()
        current.draw()
    }

    fun processUnEquip() {
        current.processUnEquip()
        current.draw()
    }

    fun processDrop() {
        current.processDrop()
        current.draw()
    }
}
