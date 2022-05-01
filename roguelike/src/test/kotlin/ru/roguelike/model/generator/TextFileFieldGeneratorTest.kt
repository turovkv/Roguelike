package ru.roguelike.model.generator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import ru.roguelike.model.Cell
import ru.roguelike.model.CellType
import ru.roguelike.model.EnemyFactoryImpl
import java.nio.file.Paths

class TextFileFieldGeneratorTest {
    @Test
    fun simpleTest() {
        val expected = mutableListOf(
            mutableListOf(Cell(CellType.NON_WALKABLE), Cell(CellType.WALKABLE), Cell(CellType.NON_WALKABLE)),
            mutableListOf(Cell(CellType.WALKABLE), Cell(CellType.WALKABLE), Cell(CellType.WALKABLE)),
            mutableListOf(Cell(CellType.NON_WALKABLE), Cell(CellType.WALKABLE), Cell(CellType.NON_WALKABLE))
        )
        val path = Paths.get("src", "test", "resources", "field.txt")

        assertEquals(expected, FieldBuilder(EnemyFactoryImpl()).fromFile(path.toFile().absolutePath).withFormat(FormatType.PLAIN).build())
    }
}
