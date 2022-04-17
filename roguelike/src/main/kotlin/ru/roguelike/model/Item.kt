package ru.roguelike.model

interface Item {
    fun use(hero: Character)
}

interface DisposableItem : Item

interface NonDisposableItem : Item {
    fun unUse(hero: Character)
}
