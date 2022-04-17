package ru.roguelike.model

import ru.roguelike.logic.CharacterStrategy

@kotlinx.serialization.Serializable
class Hero(
    override var _coordinates: Coordinates,
) : Character() {
    var armor: Int = 0
        private set

    fun use(item: Item) {
        hp = minOf(maxHp, hp + item.getHpChange())
        damage += item.getDamageChange()
        armor += item.getArmorChange()
    }

    fun unUse(item: NonDisposableItem) {
        hp = maxOf(1, hp - item.getHpChange())
        damage -= item.getDamageChange()
        armor -= item.getArmorChange()
    }
}