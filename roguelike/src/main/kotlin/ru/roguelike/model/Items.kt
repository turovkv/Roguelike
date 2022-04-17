package ru.roguelike.model

data class Shield(private val armor: Int) : NonDisposableItem {
    override fun getArmorChange(): Int = armor
}

data class Sword(private val damage: Int) : NonDisposableItem {
    override fun getDamageChange(): Int = damage
}

data class Apple(private val hp: Int) : DisposableItem {
    override fun getHpChange(): Int = hp
}