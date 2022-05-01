package ru.roguelike.model.generator.bsp

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import ru.roguelike.model.EnemyFactoryImpl
import ru.roguelike.model.generator.FieldBuilder
import java.io.FileInputStream
import java.util.*

class BuildFielderTest {
    @Test
    fun widthTest() {
        val field = FieldBuilder(EnemyFactoryImpl()).withWidth(1000).build()
        Assertions.assertEquals(1000, field[0].size)
    }

    @Test
    fun heightTest() {
        val field = FieldBuilder(EnemyFactoryImpl()).withHeight(1000).build()
        Assertions.assertEquals(1000, field.size)
    }

    @Test
    fun propertiesTest() {
        val field = FieldBuilder(EnemyFactoryImpl()).withProperties(Properties().also {
            it.load(FileInputStream("src/test/resources/map.properties"))
        }).build()

        Assertions.assertEquals(1000, field[0].size)
        Assertions.assertEquals(1000, field.size)
    }
}