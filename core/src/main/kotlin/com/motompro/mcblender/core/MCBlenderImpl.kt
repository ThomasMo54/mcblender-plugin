package com.motompro.mcblender.core

import com.motompro.mcblender.api.MCBlenderAPI
import com.motompro.mcblender.core.effect.EffectRegistryImpl

class MCBlenderImpl : MCBlenderAPI() {

    override val effectRegistry = EffectRegistryImpl()
}
