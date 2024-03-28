package com.motompro.mcblender.core.config

import org.bukkit.Color

/**
 * Represents an RGB color in a config file.
 *
 * @param r the red component
 * @param g the green component
 * @param b the blue component
 */
data class ColorConfig(
    val r: Int = 255,
    val g: Int = 255,
    val b: Int = 255,
) {

    /**
     * The Bukkit's color obtained from the color components.
     */
    val bukkitColor by lazy { Color.fromRGB(r, g, b) }
}
