package ru.roguelike.view

// INSTRUCTIONS
val AUTHORS = listOf("Kirill", "Andrey", "Misha", "Vitya")
const val DESCRIPTION = "Just nice game bro"
val INSTRUCTIONS = mapOf(
    Pair("H", "Help"),
    Pair("M", "Map"),
    Pair("I", "Inventory"),
)

// MAP
const val WALKABLE_CHAR = '.'
const val NON_WALKABLE_CHAR = '#'

// CHARACTER
const val CHARACTER_CHAR = '*'

// INVENTORY
const val SWORD_CHAR = '$'
const val SHIELD_CHAR = '-'
const val APPLE_CHAR = '@'

//ENEMY
const val AGRESSIVE_CHAR = 'A'
const val PASSIVE_CHAR = 'P'
const val SNEAKY_CHAR = 'S'