package com.motompro.mcblender.api.effect

import org.bukkit.Location

/**
 * An interface that describes a particle effect.
 */
interface Effect {

    /**
     * Spawn an instance of this effect to the given location. It will be visible by everyone.
     *
     * @param location the location
     * @return an instance of this effect
     */
    fun spawn(location: Location): EffectInstance
}
