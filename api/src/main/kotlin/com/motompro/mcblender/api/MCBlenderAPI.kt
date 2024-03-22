package com.motompro.mcblender.api

import com.motompro.mcblender.api.effect.EffectRegistry
import java.util.ServiceLoader

/**
 * The entry point of the MCBlender API.
 */
abstract class MCBlenderAPI {

    /**
     * The registry of effects. Used to load effects.
     */
    abstract val effectRegistry: EffectRegistry

    companion object {
        private val API by lazy {
            ServiceLoader.load(MCBlenderAPI::class.java, MCBlenderAPI::class.java.classLoader)
                .findFirst().orElseThrow() as MCBlenderAPI
        }
    }
}
