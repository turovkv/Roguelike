package ru.roguelike.model.generator.bsp

import org.junit.jupiter.api.Test
import ru.roguelike.model.EnemyFactoryImpl

class BSPFieldGeneratorTest {

    @Test
    fun generatorStressTest() {
        (1..100).forEach { _ ->
            BSPFieldGenerator(EnemyFactoryImpl()).generate()
        }
    }
}
