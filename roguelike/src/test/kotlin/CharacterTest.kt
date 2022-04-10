import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.roguelike.model.Character
import ru.roguelike.model.Coordinates

class CharacterTest {
    @Test
    fun testLeft() {
        val c = Character()

        val old = c.coordinates.copy()
        val expected = Coordinates(old.x - 1, old.y)

        c.moveLeft()

        Assertions.assertEquals(expected, c.coordinates)
    }
}
