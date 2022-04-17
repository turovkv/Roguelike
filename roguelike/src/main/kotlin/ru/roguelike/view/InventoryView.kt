package ru.roguelike.view

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.screen.Screen
import ru.roguelike.model.*


class InventoryView(
    private val inventory: InventoryModel,
    private val screen: Screen
) : Drawable {
    override fun draw() {
        screen.clear()

        for ((index, item) in inventory.items.withIndex()) {
            var currentCharacter = when (item) {
                is Shield -> TextCharacter.fromCharacter(SHIELD_CHAR)[0]
                is Sword -> TextCharacter.fromCharacter(SWORD_CHAR)[0]
                is Apple -> TextCharacter.fromCharacter(APPLE_CHAR)[0]
                else -> {TextCharacter.fromCharacter(NON_WALKABLE_CHAR)[0]}
            }
            if (index in inventory.equippedItems) {
                currentCharacter = currentCharacter.withBackgroundColor(TextColor.RGB(0, 255, 0))
            }
            if (index == inventory.currentItemIndex) {
                currentCharacter = currentCharacter.withBackgroundColor(TextColor.RGB(0, 0, 255))
            }
            screen.setCharacter(
                0, index,
                currentCharacter
            )
            for ((characterIndex, character) in item.toString().withIndex()){
                screen.setCharacter(
                    characterIndex + 2, index,
                    TextCharacter.fromCharacter(character)[0]
                )
            }
        }
        screen.refresh()
    }


}