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
        println("i")

        screen.clear()
        screen.refresh()
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
        while (i * screen.terminalSize.columns < description.length) {
            for (column in description.subSequence(i * screen.terminalSize.columns, min(i * screen.terminalSize.columns + screen.terminalSize.columns, description.length)).indices) {
                for (row in i until i + 1) {
                    screen.setCharacter(
                        column, row,
                        TextCharacter.fromCharacter(description[column])[0]
                    )
                }
                println((description[column]))
            }
            i += 1
        }
        i += 1
        var begin_i = i
        println(authors)
        while ((i - begin_i) * screen.terminalSize.columns < authors.length) {
            for (column in authors.subSequence((i - begin_i) * screen.terminalSize.columns, min((i - begin_i) * screen.terminalSize.columns + screen.terminalSize.columns, authors.length)).indices) {
                for (row in i  until i + 1) {
                    screen.setCharacter(
                        column, row,
                        TextCharacter.fromCharacter(authors[column])[0]
                    )
                    println(1)
                }
            }
            i += 1
        }
        for (j in instructionPairs) {
            i += 1
            begin_i = i
            while ((i - begin_i)  * screen.terminalSize.columns< j.length) {
                for (column in j.subSequence((i - begin_i) * screen.terminalSize.columns, min((i - begin_i) * screen.terminalSize.columns + screen.terminalSize.columns, j.length)).indices) {
                    for (row in i until i + 1) {
                        screen.setCharacter(
                            column, row,
                            TextCharacter.fromCharacter(j[column])[0]
                        )
                    }
                }
                i += 1
            }
        }
        screen.refresh()
    }
}
