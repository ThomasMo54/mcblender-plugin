package com.motompro.mcblender.api.effect

import org.bukkit.Location
import org.bukkit.entity.Player

/**
 * An interface that describes an instance of a particle effect
 */
interface EffectInstance {

    /**
     * The current location of this effect. Can be modified to move the effect.
     */
    val location: Location

    /**
     * The list of players who can see this effect. If it is empty then every player can see it.
     *
     * Empty by default.
     */
    val playersWhoCanSee: List<Player>

    /**
     * Set to *true* if this effect should be visible, *false* otherwise.
     */
    var isVisible: Boolean

    /**
     * Set to *true* to play this effect. Set to *false* to pause this effect.
     */
    var isPlaying: Boolean

    /**
     * *true* if this effect is destroyed, *false* otherwise.
     */
    val isDestroyed: Boolean

    /**
     * Add players to the list of players who can see this effect.
     *
     * @param players the players to add
     */
    fun addPlayersWhoCanSee(players: Collection<Player>)

    /**
     * Add players to the list of players who can see this effect.
     *
     * @param players the players to add
     */
    fun addPlayersWhoCanSee(vararg players: Player)

    /**
     * Remove players to the list of players who can see this effect.
     *
     * @param players the players to remove
     */
    fun removePlayersWhoCanSee(players: Collection<Player>)

    /**
     * Remove players to the list of players who can see this effect.
     *
     * @param players the players to remove
     */
    fun removePlayersWhoCanSee(vararg players: Player)

    /**
     * Make this effect visible for every player (= clearing the [playersWhoCanSee] list).
     */
    fun makeVisibleForEveryone()

    /**
     * Make this effect disappear.
     */
    fun destroy()
}
