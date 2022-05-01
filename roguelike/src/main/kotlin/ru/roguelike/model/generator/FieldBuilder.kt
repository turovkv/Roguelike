package ru.roguelike.model.generator

import ru.roguelike.model.EnemyFactory
import ru.roguelike.model.Field
import ru.roguelike.model.generator.bsp.BSPFieldGenerator
import ru.roguelike.util.Constants
import java.util.Properties

enum class FormatType {
    JSON,
    PLAIN
}

class FieldBuilder(private val factory: EnemyFactory) {
    private var width = Constants.FIELD_WIDTH
    private var height = Constants.FIELD_HEIGHT
    private var filePath: String? = null
    private var fileFormatType: FormatType = FormatType.JSON

    fun build(): Field =
        if (filePath == null) {
            BSPFieldGenerator(factory).generate()
        } else {
            filePath?.let {
                when (fileFormatType) {
                    FormatType.JSON -> JsonFileFieldGenerator(it).generate()
                    FormatType.PLAIN -> TextFileFieldGenerator(it).generate()
                }
            } ?: throw IllegalStateException("File path is not specified")
        }

    fun withWidth(width: Int): FieldBuilder {
        this.width = width
        return this
    }

    fun withHeight(height: Int): FieldBuilder {
        this.height = height
        return this
    }

    fun fromFile(path: String): FieldBuilder {
        filePath = path
        return this
    }

    fun withFormat(formatType: FormatType): FieldBuilder {
        fileFormatType = formatType
        return this
    }

    fun withProperties(prop: Properties): FieldBuilder {
        prop.getProperty("width")?.toInt()?.let { withWidth(it) }
        prop.getProperty("height")?.toInt()?.let { withHeight(it) }
        prop.getProperty("format")?.let {
            withFormat(FormatType.valueOf(it))
        }
        prop.getProperty("path")?.let { fromFile(it) }

        return this
    }
}
