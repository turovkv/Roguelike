package ru.roguelike.model

import ru.roguelike.util.Constants
import kotlin.random.Random
import kotlin.random.nextInt

object Items {
    fun createRandomItem(): Item = when (Random.nextInt(3)) {
        0 -> Shield(Random.nextInt(1..Constants.MAX_ARMOR))
        1 -> Sword(Random.nextInt(1..Constants.MAX_DAMAGE))
        2 -> Apple(Random.nextInt(1..Constants.MAX_HP))
        else -> error("Unreachable")
    }
}

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
