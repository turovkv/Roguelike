package ru.roguelike.model.generator.bsp

import ru.roguelike.model.Coordinates
import kotlin.math.abs
import kotlin.random.Random

/**
 * Direction of tunnel
 */
internal enum class DirectionType {
    VERTICAL,
    HORIZONTAL
}

/**
 * Class that represents tunnel between two rooms
 */
internal data class Tunnel(
    val direction: DirectionType,
    val coordinates: Coordinates,
    val length: Int
) {
    companion object {
        /**
         * Create path between two rooms. If it is impossible to create path by one tunnel
         * then create right corner using two tunnels
         */
        internal fun createTunnels(left: Room, right: Room): List<Tunnel> {
            val tunnels = mutableListOf<Tunnel>()

            val leftCoordinates = left.randomPoint
            val rightCoordinates = right.randomPoint

            val width = rightCoordinates.x - leftCoordinates.x
            val height = rightCoordinates.y - leftCoordinates.y

            if (height == 0) {
                if (width < 0) {
                    leftCoordinates.swapX(rightCoordinates)
                }

                tunnels.add(Tunnel(DirectionType.HORIZONTAL, leftCoordinates, abs(width) + 1))
                return tunnels
            }

            if (width < 0) {
                if (height > 0) {
                    when (Random.nextBoolean()) {
                        /**
                         * r *
                         * _ l
                         */
                        true -> {
                            tunnels.add(Tunnel(DirectionType.VERTICAL, leftCoordinates, height + 1))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, rightCoordinates, -width + 1))
                        }
                        /**
                         * r _
                         * * l
                         */
                        false -> {
                            tunnels.add(Tunnel(DirectionType.VERTICAL, Coordinates(rightCoordinates.x, leftCoordinates.y), height + 1))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(rightCoordinates.x, leftCoordinates.y), -width + 1))
                        }
                    }
                } else {
                    when (Random.nextBoolean()) {
                        /**
                         * * l
                         * r _
                         */
                        true -> {
                            tunnels.add(Tunnel(DirectionType.VERTICAL, rightCoordinates, -height + 1))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(rightCoordinates.x, leftCoordinates.y), -width + 1))
                        }
                        /**
                         * _ l
                         * r *
                         */
                        false -> {
                            tunnels.add(Tunnel(DirectionType.VERTICAL, Coordinates(leftCoordinates.x, rightCoordinates.y), -height + 1))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, rightCoordinates, -width + 1))
                        }
                    }
                }
            } else if (width > 0) {
                if (height > 0) {
                    when (Random.nextBoolean()) {
                        true -> {
                            /**
                             * _ r
                             * l *
                             */
                            tunnels.add(Tunnel(DirectionType.VERTICAL, Coordinates(rightCoordinates.x, leftCoordinates.y), height + 1))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, leftCoordinates, width + 1))
                        }
                        false -> {
                            /**
                             * * r
                             * l _
                             */
                            tunnels.add(Tunnel(DirectionType.VERTICAL, leftCoordinates, height + 1))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(leftCoordinates.x, rightCoordinates.y), width + 1))
                        }
                    }
                } else {
                    when (Random.nextBoolean()) {
                        true -> {
                            /**
                             * l _
                             * * r
                             */
                            tunnels.add(Tunnel(DirectionType.VERTICAL, Coordinates(leftCoordinates.x, rightCoordinates.y), -height + 1))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(leftCoordinates.x, rightCoordinates.y), width + 1))
                        }
                        false -> {
                            /**
                             * l *
                             * _ r
                             */
                            tunnels.add(Tunnel(DirectionType.VERTICAL, rightCoordinates, -height + 1))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, leftCoordinates, width + 1))
                        }
                    }
                }
            } else {
                if (height < 0) {
                    leftCoordinates.swapY(rightCoordinates)
                }

                tunnels.add(Tunnel(DirectionType.VERTICAL, leftCoordinates, abs(height) + 1))
            }

            return tunnels
        }
    }
}
