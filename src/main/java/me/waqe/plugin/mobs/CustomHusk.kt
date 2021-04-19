package me.waqe.plugin.mobs

import net.md_5.bungee.api.ChatColor
import net.minecraft.server.v1_16_R2.*
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld

class CustomHusk(loc: Location) : EntityZombieHusk(EntityTypes.HUSK, (loc.world as CraftWorld).handle) {
    fun CustomHusk(loc: Location) {
        this.setPosition(loc.x, loc.y, loc.z)

        isBaby = true
        customName = ChatComponentText("${ChatColor.YELLOW}Husky")
        customNameVisible = true
    }

    override fun initPathfinder() {
        this.goalSelector.a(0, PathfinderGoalFloat(this))
        this.goalSelector.a(4, PathfinderGoalMeleeAttack(this, 1.0, true))
        this.goalSelector.a(5, PathfinderGoalMoveTowardsRestriction(this, 0.2))
        this.goalSelector.a(6, PathfinderGoalMoveThroughVillage(this, 0.2, false, 1, null))
        this.goalSelector.a(7, PathfinderGoalRandomStroll(this, 0.2))
        this.goalSelector.a(8, PathfinderGoalRandomLookaround(this))
        this.goalSelector.a(8, PathfinderGoalLookAtPlayer(this, EntityHuman::class.java, 8.0f))

        this.targetSelector.a(1, PathfinderGoalHurtByTarget(this))
        this.targetSelector.a(PathfinderGoalNearestAttackableTarget<EntityChicken>(this, EntityChicken::class.java, true))
        this.targetSelector.a(3, PathfinderGoalAvoidTarget<EntityTurtle>(this, EntityTurtle::class.java, 20.0F, 1.0, 1.0))
     }
}