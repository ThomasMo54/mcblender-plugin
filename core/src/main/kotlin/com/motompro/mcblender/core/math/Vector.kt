package com.motompro.mcblender.core.math

import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.sin

/**
 * Some extensions for Bukkit's [Vector].
 */
object Vector {

    /**
     * Rotate this vector around the X axis by the given angle.
     *
     * @param angle the angle in radians
     * @return this [Vector] for chain call
     */
    fun Vector.rotateAroundX(angle: Double): Vector {
        val angleCos = cos(angle)
        val angleSin = sin(angle)
        val y = angleCos * this.y - angleSin * this.z
        val z = angleSin * this.y + angleCos * this.z
        return this.setY(y).setZ(z)
    }

    /**
     * Rotate this vector around the Y axis by the given angle.
     *
     * @param angle the angle in radians
     * @return this [Vector] for chain call
     */
    fun Vector.rotateAroundY(angle: Double): Vector {
        val angleCos = cos(angle)
        val angleSin = sin(angle)
        val x = angleCos * this.x + angleSin * this.z
        val z = -angleSin * this.x + angleCos * this.z
        return this.setX(x).setZ(z)
    }

    /**
     * Rotate this vector around the Z axis by the given angle.
     *
     * @param angle the angle in radians
     * @return this [Vector] for chain call
     */
    fun Vector.rotateAroundZ(angle: Double): Vector {
        val angleCos = cos(angle)
        val angleSin = sin(angle)
        val x = angleCos * this.x - angleSin * this.y
        val y = angleSin * this.x + angleCos * this.y
        return this.setX(x).setY(y)
    }
}
