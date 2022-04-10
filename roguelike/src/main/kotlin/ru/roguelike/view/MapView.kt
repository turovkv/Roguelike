package ru.roguelike.view

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.screen.Screen
import ru.roguelike.model.CellType
import ru.roguelike.model.MapModel
/*
 This class provides one method which draws map and character.
 */
class MapView(
    private val map: MapModel,
    private val screen: Screen,
    private val characterView: CharacterView
) : Drawable {
    /*
     This method draws map and character.
     */
    override fun draw() {
        screen.clear()
        for (column in 0 until map.getY()) {
            for (row in 0 until map.getX()) {
                screen.setCharacter(
                    column, row,
                    when (map.field[column][row].cellType) {
                        CellType.WALKABLE -> TextCharacter.fromCharacter(WALKABLE_CHAR)[0]
                        CellType.NON_WALKABLE -> TextCharacter.fromCharacter(NON_WALKABLE_CHAR)[0]
                    }
                )
            }
        }
        characterView.draw()
        screen.refresh()
    }
}
