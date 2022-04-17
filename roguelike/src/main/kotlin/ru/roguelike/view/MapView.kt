package ru.roguelike.view

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.screen.Screen
import ru.roguelike.model.CellType
import ru.roguelike.model.MapModel
import ru.roguelike.util.Constants.ERROR_VIEW_HEIGHT

/**
 * This class provides one method which draws map and character.
 */
@kotlinx.serialization.Serializable
class MapView(
    private val map: MapModel,
    private val screen: Screen,
    private val characterView: CharacterView
) : Drawable {
    /**
     * This method draws map and character.
     */
    override fun draw() {
        screen.clear()
        for (row in ERROR_VIEW_HEIGHT until map.getY() + ERROR_VIEW_HEIGHT) {
            for (column in 0 until map.getX()) {
                screen.setCharacter(
                    column, row,
                    when (map.field[row - ERROR_VIEW_HEIGHT][column].cellType) {
                        CellType.WALKABLE -> TextCharacter.fromCharacter(WALKABLE_CHAR)[0]
                        CellType.NON_WALKABLE -> TextCharacter.fromCharacter(NON_WALKABLE_CHAR)[0]
                    }
                )
            }
        }
        characterView.type = "MAP"
        characterView.draw()
        screen.refresh()
    }
}
