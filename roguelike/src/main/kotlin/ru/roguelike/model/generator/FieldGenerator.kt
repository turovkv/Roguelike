package ru.roguelike.model.generator

import ru.roguelike.model.Field

interface FieldGenerator {
    fun generate(): Field
}
