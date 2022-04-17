package ru.roguelike.logic

import ru.roguelike.model.Hero
import ru.roguelike.model.InventoryModel
import ru.roguelike.model.MapModel
import ru.roguelike.model.NonDisposableItem
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
    override fun processEquip() {
        inventoryModel.getCurrentItem().let { item ->
            if (!inventoryModel.isCurrentItemEquipped()) {
                character.use(item)
                inventoryModel.useCurrentItem()
            }
        }
    }

    override fun processUnEquip() {
        inventoryModel.getCurrentItem().let { item ->
            if (item is NonDisposableItem && inventoryModel.isCurrentItemEquipped()) {
                character.unUse(item)
                inventoryModel.unUseCurrentItem()
            }
        }
    }

    override fun processDrop() {
        if (mapModel.field[character.coordinates.y][character.coordinates.x].item != null) {
            return
        }

        inventoryModel.getCurrentItem().let { item ->
            if (!inventoryModel.isCurrentItemEquipped()) {
                inventoryModel.dropCurrentItem()
                mapModel.field[character.coordinates.y][character.coordinates.x].item = item
            }
        }
    }

    override fun moveUp() {
        inventoryModel.moveUp()
    }

    override fun moveDown() {
        inventoryModel.moveDown()
    }

    override fun draw() {
        view.draw()
    }
}
