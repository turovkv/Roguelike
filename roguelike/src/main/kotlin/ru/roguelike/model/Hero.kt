package ru.roguelike.model

/**
 * Class that store information about hero
 */
class Hero(
    override var _coordinates: Coordinates,
) : Character() {
    /**
     * Begin to use the item
     */
    fun use(item: Item) {
        hp = minOf(maxHp, hp + item.getHpChange())
        damage += item.getDamageChange()
        armor += item.getArmorChange()
    }

    /**
     * End to use the item
     */
    fun unUse(item: NonDisposableItem) {
        hp = maxOf(1, hp - item.getHpChange())
        damage -= item.getDamageChange()
        armor -= item.getArmorChange()
    }
}
