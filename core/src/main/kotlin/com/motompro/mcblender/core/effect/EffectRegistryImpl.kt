package com.motompro.mcblender.core.effect

import com.motompro.mcblender.api.effect.Effect
import com.motompro.mcblender.api.effect.EffectRegistry
import com.motompro.mcblender.core.MCBlenderPlugin
import com.motompro.mcblender.core.config.EffectConfig
import com.motompro.mcblender.core.config.PluginConfig
import com.motompro.mcblender.core.particle.ParticleUnit
import org.bukkit.Particle
import java.io.File

class EffectRegistryImpl : EffectRegistry {

    override fun loadEffect(fileName: String): Effect {
        val effectFile = File(MCBlenderPlugin.INSTANCE.effectsDir, fileName)
        return loadEffect(effectFile)
    }

    override fun loadEffect(file: File): Effect {
        val effectConfig = PluginConfig.loadFromFile(file, EffectConfig::class.java)
        val particles = effectConfig.particles.map {
            ParticleUnit(Particle.valueOf(it.type), it.color?.bukkitColor, it.location.vector)
        }
        val effect = EffectImpl(particles)
        return effect
    }
}
