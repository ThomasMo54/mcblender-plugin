package com.motompro.mcblender.core.command

import com.motompro.mcblender.core.MCBlenderPlugin
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class MCBRemoveCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, name: String, args: Array<out String>): Boolean {
        if (args.size != 1) {
            sender.sendMessage("${ChatColor.RED}Syntax: /mcbremove <effect id>")
            return true
        }
        val effectId = args[0].toInt()
        val effectInstance = MCBlenderPlugin.INSTANCE.spawnedEffects[effectId] ?: run {
            sender.sendMessage("${ChatColor.RED}No existing effect with id $effectId.")
            return true
        }
        effectInstance.destroy()
        MCBlenderPlugin.INSTANCE.spawnedEffects.remove(effectId)
        sender.sendMessage("${ChatColor.GREEN}Effect successfully removed.")
        return false
    }
}
