package com.motompro.mcblender.api

import com.motompro.mcblender.api.effect.EffectRegistry

/**
 * The entry point of the MCBlender API.
 */
abstract class MCBlenderAPI {

    /**
     * The registry of effects. Used to load effects.
     */
    abstract val effectRegistry: EffectRegistry

    companion object {
        lateinit var API: MCBlenderAPI
    }
}
