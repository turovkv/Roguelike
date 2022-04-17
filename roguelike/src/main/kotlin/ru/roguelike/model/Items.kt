package ru.roguelike.model

data class Shield(private val armor: Int) : NonDisposableItem {
    override fun getArmorChange(): Int = armor
    override fun toString(): String {
        return "SHIELD, ARMOUR +" + getArmorChange().toString()
    }
}

data class Sword(private val damage: Int) : NonDisposableItem {
    override fun getDamageChange(): Int = damage
    override fun toString(): String {
        return "SWORD, DAMAGE +" + getDamageChange().toString()
    }
}

data class Apple(private val hp: Int) : DisposableItem {
    override fun getHpChange(): Int = hp
    override fun toString(): String {
        return "APPLE, HP +" + getHpChange().toString()
    }
}
