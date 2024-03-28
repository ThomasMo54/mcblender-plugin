package com.motompro.mcblender.core.effect

import com.motompro.mcblender.api.effect.Effect
import com.motompro.mcblender.api.effect.EffectInstance
import com.motompro.mcblender.core.particle.ParticleUnit
import org.bukkit.Location

class EffectImpl(
    private val particles: List<ParticleUnit>,
) : Effect {
    
    override fun spawn(location: Location): EffectInstance {
        return EffectInstanceImpl(location, particles.map { it.clone() })
    }
}
