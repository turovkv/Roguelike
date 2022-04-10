package ru.roguelike.view

import com.googlecode.lanterna.TextCharacter
import com.googlecode.lanterna.screen.Screen
import ru.roguelike.model.InstructionModel
import java.lang.Integer.min

class InstructionsView(
    private val instructions: InstructionModel,
    private val screen: Screen
) : Drawable {
    override fun draw() {
        screen.clear()
        val description = instructions.description
        var authors = ""
        for (i in instructions.authors) {
            authors += if (authors != "")
                ", $i"
            else
                i
        }
        val instructionPairs = MutableList(instructions.instructions.size) { "" }
        for (i in instructions.instructions.keys) {
            instructionPairs.add(i + ": " + instructions.instructions[i])
        }
        var i = 0
        i = addStringToScreen(i, 0, description) + 1
        i = addStringToScreen(i, i, authors) + 1
        for (str in instructionPairs) {
            i = addStringToScreen(i, i, str)
        }
        screen.refresh()
    }

    private fun addStringToScreen(i: Int, begin_i: Int, str: String): Int {
        var i1 = i
        while ((i1 - begin_i) * screen.terminalSize.columns < str.length) {
            for (
                column in str.subSequence(
                    (i1 - begin_i) * screen.terminalSize.columns,
                    min((i1 - begin_i) * screen.terminalSize.columns + screen.terminalSize.columns, str.length)
                ).indices
            ) {
                for (row in i1 until i1 + 1) {
                    screen.setCharacter(
                        column, row,
                        TextCharacter.fromCharacter(
                            str.subSequence(
                                (i1 - begin_i) * screen.terminalSize.columns,
                                min(
                                    (i1 - begin_i) * screen.terminalSize.columns + screen.terminalSize.columns,
                                    str.length
                                )
                            )[column]
                        )[0]
                    )
                }
            }
            i1 += 1
        }
        return i1
    }
}
