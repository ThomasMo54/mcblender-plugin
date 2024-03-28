package com.motompro.mcblender.core.particle

import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.entity.Player
import org.bukkit.util.Vector

/**
 * A class representing one unique particle with its type, relative location and color if needed.
 */
class ParticleUnit(
    private val type: Particle,
    private val color: Color?,
    private val initialLocation: Vector,
) {

    private val formattedColor = if (color == null) {
        listOf(0.0, 0.0, 0.0)
    } else {
        listOf(if (color.red == 0) Float.MIN_VALUE.toDouble() else color.red / 255.0, color.green / 255.0, color.blue / 255.0)
    }
    private var location = initialLocation.clone()

    /**
     * Update this particle state if needed
     */
    fun update(anchorPoint: Location) {

    }

    /**
     * Show this particle to everyone. It will be spawned relatively to the given anchor point.
     *
     * @param anchorPoint the anchor location
     */
    fun render(anchorPoint: Location) {
        anchorPoint.world.spawnParticle(
            type,
            anchorPoint.x + location.x,
            anchorPoint.y + location.y,
            anchorPoint.z + location.z,
            0,
            formattedColor[0],
            formattedColor[1],
            formattedColor[2],
        )
    }

    /**
     * Show this particle to the given players. It will be spawned relatively to the given anchor point.
     *
     * @param anchorPoint the anchor location
     * @param playersWhoCanSee the players who can see this particle
     */
    fun render(anchorPoint: Location, playersWhoCanSee: Collection<Player>) {
        playersWhoCanSee.forEach { player ->
            player.spawnParticle(
                type,
                anchorPoint.x + location.x,
                anchorPoint.y + location.y,
                anchorPoint.z + location.z,
                0,
                formattedColor[0],
                formattedColor[1],
                formattedColor[2],
            )
        }
    }

    /**
     * Make a copy of this particle.
     */
    fun clone(): ParticleUnit {
        return ParticleUnit(type, color, initialLocation)
    }
}
