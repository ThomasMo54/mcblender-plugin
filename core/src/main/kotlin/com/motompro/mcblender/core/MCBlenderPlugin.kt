package com.motompro.mcblender.core

import com.motompro.mcblender.api.MCBlenderAPI
import com.motompro.mcblender.api.effect.EffectInstance
import com.motompro.mcblender.core.command.MCBRemoveCommand
import com.motompro.mcblender.core.command.MCBSpawnCommand
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

private const val EFFECTS_DIR_NAME = "effects"

class MCBlenderPlugin : JavaPlugin() {

    val effectsDir = File(dataFolder, EFFECTS_DIR_NAME)

    val spawnedEffects = mutableMapOf<Int, EffectInstance>()

    override fun onLoad() {
        super.onLoad()
        INSTANCE = this
        MCBlenderAPI.API = MCBlenderImpl()
    }

    override fun onEnable() {
        super.onEnable()

        // Create config directories
        if (!effectsDir.exists()) effectsDir.mkdirs()

        // Register commands
        getCommand("mcbspawn").executor = MCBSpawnCommand()
        getCommand("mcbremove").executor = MCBRemoveCommand()
    }

    companion object {
        lateinit var INSTANCE: MCBlenderPlugin
    }
}
