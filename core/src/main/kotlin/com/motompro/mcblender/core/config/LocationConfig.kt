package com.motompro.mcblender.core.config

import org.bukkit.util.Vector

/**
 * Represents a location in a config file.
 *
 * @param x the X coordinate
 * @param y the Y coordinate
 * @param z the Z coordinate
 */
data class LocationConfig(
    val x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0,
) {

    /**
     * The vector obtained by the location's coordinates.
     */
    val vector: Vector by lazy { Vector(x, y, z) }
}
