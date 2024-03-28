package com.motompro.mcblender.core.command

import com.motompro.mcblender.api.MCBlenderAPI
import com.motompro.mcblender.core.MCBlenderPlugin
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.io.FileNotFoundException
import java.io.IOException

class MCBSpawnCommand : CommandExecutor {

    private val effectIdSequence = generateSequence(0) { it + 1 }.iterator()

    override fun onCommand(sender: CommandSender, command: Command, name: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${ChatColor.RED}This command must be executed by an in-game player.")
            return true
        }
        if (args.size != 1 && args.size != 4) {
            sender.sendMessage("${ChatColor.RED}Syntax: /mcbspawn <effect> [x] [y] [z]")
            return true
        }
        val effectName = args[0]
        val effect = try {
            MCBlenderAPI.API.effectRegistry.loadEffect("${effectName}.yml")
        } catch (ex: FileNotFoundException) {
            sender.sendMessage("${ChatColor.RED}This effect's file does not exist.")
            return true
        } catch (ex: IOException) {
            sender.sendMessage("${ChatColor.RED}Error when loading this effect.")
            return true
        }
        val id = effectIdSequence.next()
        val successMessage = "${ChatColor.GREEN}Effect successfully spawned. Run the command ${ChatColor.GOLD}/mcbremove $id ${ChatColor.GREEN}to remove it."
        if (args.size == 1) {
            val instance = effect.spawn(sender.location)
            MCBlenderPlugin.INSTANCE.spawnedEffects[id] = instance
            sender.sendMessage(successMessage)
            return false
        }
        val spawnLocation = Location(sender.world, args[1].toDouble(), args[2].toDouble(), args[3].toDouble())
        val instance = effect.spawn(spawnLocation)
        MCBlenderPlugin.INSTANCE.spawnedEffects[id] = instance
        sender.sendMessage(successMessage)
        return false
    }
}
