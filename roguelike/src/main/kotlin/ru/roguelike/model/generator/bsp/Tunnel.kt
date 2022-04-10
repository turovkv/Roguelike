package ru.roguelike.model.generator.bsp

import ru.roguelike.model.Coordinates
import kotlin.math.abs
import kotlin.random.Random

internal enum class DirectionType {
    VERTICAL,
    HORIZONTAL
}

internal data class Tunnel(
    val direction: DirectionType,
    val coordinates: Coordinates,
    val length: Int
) {
    companion object {
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

                tunnels.add(Tunnel(DirectionType.HORIZONTAL, leftCoordinates, abs(width)))
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
                            tunnels.add(Tunnel(DirectionType.VERTICAL, leftCoordinates, height))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, rightCoordinates, -width))
                        }
                        /**
                         * r _
                         * * l
                         */
                        false -> {
                            tunnels.add(Tunnel(DirectionType.VERTICAL, Coordinates(rightCoordinates.x, leftCoordinates.y), height))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(rightCoordinates.x, leftCoordinates.y), -width))
                        }
                    }
                } else if (height < 0) {
                    when (Random.nextBoolean()) {
                        /**
                         * * l
                         * r _
                         */
                        true -> {
                            tunnels.add(Tunnel(DirectionType.VERTICAL, rightCoordinates, -height))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(rightCoordinates.x, leftCoordinates.y), -width))
                        }
                        /**
                         * _ l
                         * r *
                         */
                        false -> {
                            tunnels.add(Tunnel(DirectionType.VERTICAL, Coordinates(leftCoordinates.x, rightCoordinates.y), -height))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, rightCoordinates, -width))
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
                            tunnels.add(Tunnel(DirectionType.VERTICAL, Coordinates(rightCoordinates.x, leftCoordinates.y), height))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, leftCoordinates, width))
                        }
                        false -> {
                            /**
                             * * r
                             * l _
                             */
                            tunnels.add(Tunnel(DirectionType.VERTICAL, leftCoordinates, height))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(leftCoordinates.x, rightCoordinates.y), height))
                        }
                    }
                } else {
                    when (Random.nextBoolean()) {
                        true -> {
                            /**
                             * l _
                             * * r
                             */
                            tunnels.add(Tunnel(DirectionType.VERTICAL, Coordinates(leftCoordinates.x, rightCoordinates.y), -height))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(leftCoordinates.x, rightCoordinates.y), width))
                        }
                        false -> {
                            /**
                             * l *
                             * _ r
                             */
                            tunnels.add(Tunnel(DirectionType.VERTICAL, rightCoordinates, -height))
                            tunnels.add(Tunnel(DirectionType.HORIZONTAL, Coordinates(rightCoordinates.x, leftCoordinates.y), width))
                        }
                    }
                }
            } else {
                if (height < 0) {
                    leftCoordinates.swapY(rightCoordinates)
                }

                tunnels.add(Tunnel(DirectionType.VERTICAL, leftCoordinates, abs(height)))
            }

            return tunnels
        }
    }
}
