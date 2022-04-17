package ru.roguelike.model

interface Item {
    fun getHpChange(): Int = 0
    fun getDamageChange(): Int = 0
    fun getArmorChange(): Int = 0
    override fun toString(): String
}

interface DisposableItem : Item

interface NonDisposableItem : Item
