package me.waqe.plugin.commands

import me.waqe.plugin.mobs.CustomHusk
import net.minecraft.server.v1_16_R2.WorldServer
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
//import net.minecraft.server.v1_16_R2.*
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld

class SpawnMob : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (label.equals("spawnhusk", ignoreCase = true)) {
            if (sender !is Player) return true

            val player = sender
            val h = (player.world as CraftWorld).handle

            val world: WorldServer = h
            val husky: CustomHusk = CustomHusk(player.location)
            world.addEntity(husky)
            return true
        }
        return false
    }
}