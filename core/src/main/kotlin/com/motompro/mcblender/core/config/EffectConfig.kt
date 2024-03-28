package com.motompro.mcblender.core.config

/**
 * Represents a whole effect in a config file.
 *
 * @param particles the list of particles composing this effect
 */
data class EffectConfig(
    val particles: List<ParticleConfig> = emptyList(),
)
