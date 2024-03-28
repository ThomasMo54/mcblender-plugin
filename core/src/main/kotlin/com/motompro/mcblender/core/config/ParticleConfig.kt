package com.motompro.mcblender.core.config

import org.bukkit.Particle

/**
 * Represents an unique particle in a config file.
 *
 * @param type the type of this particle. Must be a Bukkit's [Particle]
 * @param color the color of this particle
 * @param location the relative location of this particle
 */
data class ParticleConfig(
    val type: String = Particle.REDSTONE.name,
    val color: ColorConfig? = null,
    val location: LocationConfig = LocationConfig(),
)
