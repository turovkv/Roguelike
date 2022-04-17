package ru.roguelike.model

import ru.roguelike.util.Constants

@kotlinx.serialization.Serializable
class InventoryModel(private val items_: MutableList<Item> = mutableListOf()) {
    val items: List<Item> get() = items_
    var currentItemIndex: Int = 0
        private set
    private var equippedItems_: MutableSet<Int> = mutableSetOf()
    val equippedItems: Set<Int> get() = equippedItems_

    fun moveDown() {
        if (currentItemIndex < Constants.INVENTORY_SIZE - 1) {
            currentItemIndex++
        }
    }

    fun moveUp() {
        if (currentItemIndex > 0) {
            currentItemIndex--
        }
    }

    fun getCurrentItem(): Item {
        return items_[currentItemIndex]
    }

    // TODO(): инвариант при вызове, текущий предмет используется
    fun unUseCurrentItem() {
        equippedItems_.remove(currentItemIndex)
    }

    // TODO(): инвариант при вызове, текущий предмет не используется
    fun useCurrentItem() {
        when (items_[currentItemIndex]) {
            is DisposableItem -> dropCurrentItem()
            is NonDisposableItem -> equippedItems_.add(currentItemIndex)
        }
    }

    // TODO(): инвариант при вызове, текущий предмет не используется
    fun dropCurrentItem() {
        items_.removeAt(currentItemIndex)
    }

    fun addItem(item: Item) {
        items_.add(item)
    }

    fun isCurrentItemEquipped(): Boolean {
        return equippedItems_.contains(currentItemIndex)
    }
}
