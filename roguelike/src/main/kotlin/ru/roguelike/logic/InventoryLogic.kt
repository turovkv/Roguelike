package ru.roguelike.logic

import ru.roguelike.model.Hero
import ru.roguelike.model.InventoryModel
import ru.roguelike.model.MapModel
import ru.roguelike.model.NonDisposableItem
import ru.roguelike.util.Constants
import ru.roguelike.view.Drawable

/**
 * Class that stores logic about inventory
 */
class InventoryLogic(
    private val character: Hero,
    private val inventoryModel: InventoryModel,
    private val mapModel: MapModel,
    private val view: Drawable
) : Logic {
    /**
     * processing equip current item
     */
    override fun processEquip() {
        if (inventoryModel.equippedItems.size >= Constants.MAXIMUM_EQUIPPED_ITEMS) {
            return
        }
        inventoryModel.getCurrentItem()?.let { item ->
            if (!inventoryModel.isCurrentItemEquipped()) {
                character.use(item)
                inventoryModel.useCurrentItem()
            }
        }
    }

    /**
     * processing unequip current item
     */
    override fun processUnEquip() {
        inventoryModel.getCurrentItem()?.let { item ->
            if (item is NonDisposableItem && inventoryModel.isCurrentItemEquipped()) {
                character.unUse(item)
                inventoryModel.unUseCurrentItem()
            }
        }
    }

    /**
     * processing dropping item from inventory
     */
    override fun processDrop() {
        if (mapModel.field[character.coordinates.y][character.coordinates.x].item != null) {
            return
        }

        inventoryModel.getCurrentItem()?.let { item ->
            if (!inventoryModel.isCurrentItemEquipped()) {
                inventoryModel.dropCurrentItem()
                mapModel.field[character.coordinates.y][character.coordinates.x].item = item
            }
        }
    }

    /**
     * processing moving up in inventory
     */
    override fun moveUp() {
        inventoryModel.moveUp()
    }

    /**
     * processing moving down in inventory
     */
    override fun moveDown() {
        inventoryModel.moveDown()
    }

    /**
     * Draw inventory
     */
    override fun draw() {
        view.draw()
    }
}
