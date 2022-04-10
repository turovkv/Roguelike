package ru.roguelike.logic

interface Logic {
    /*
    * обработка движения влево
    * */
    fun processLeftArrow()

    /*
    * обработка движения вправо
    * */
    fun processRightArrow()

    /*
    * обработка движения вверх
    * */
    fun processUpArrow()

    /*
    * обработка движения вниз
    * */
    fun processDownArrow()

    /*
    * отрисовать текущую логику
    * */
    fun draw()
}
