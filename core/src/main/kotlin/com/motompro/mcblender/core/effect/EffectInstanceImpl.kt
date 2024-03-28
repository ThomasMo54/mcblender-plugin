package com.motompro.mcblender.core.effect

import com.motompro.mcblender.api.effect.EffectInstance
import com.motompro.mcblender.core.MCBlenderPlugin
import com.motompro.mcblender.core.particle.ParticleUnit
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player

class EffectInstanceImpl(
    override val location: Location,
    private val particles: List<ParticleUnit>,
) : EffectInstance {

    private val _playersWhoCanSee = mutableListOf<Player>()
    override val playersWhoCanSee: List<Player>
        get() = _playersWhoCanSee

    override var isVisible: Boolean = true

    override var isPlaying: Boolean = true

    override var isDestroyed: Boolean = false

    private var effectTaskId: Int = 0

    init {
        start()
    }

    private fun start() {
        effectTaskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(
            MCBlenderPlugin.INSTANCE,
            {
                if (isVisible) {
                    if (playersWhoCanSee.isEmpty()) {
                        particles.forEach { particle -> particle.render(location) }
                    } else {
                        particles.forEach { particle -> particle.render(location, playersWhoCanSee) }
                    }
                }
                if (isPlaying) {
                    particles.forEach { particle -> particle.update(location) }
                }
            },
            0,
            1,
        )
    }

    private fun stop() {
        Bukkit.getScheduler().cancelTask(effectTaskId)
    }

    override fun addPlayersWhoCanSee(players: Collection<Player>) {
        _playersWhoCanSee.addAll(players)
    }

    override fun addPlayersWhoCanSee(vararg players: Player) {
        addPlayersWhoCanSee(players.asList())
    }

    override fun removePlayersWhoCanSee(players: Collection<Player>) {
        _playersWhoCanSee.removeAll(players)
    }

    override fun removePlayersWhoCanSee(vararg players: Player) {
        removePlayersWhoCanSee(players.asList())
    }

    override fun makeVisibleForEveryone() {
        _playersWhoCanSee.clear()
    }

    override fun rotateAroundX(angle: Double) {
        TODO("Not yet implemented")
    }

    override fun rotateAroundY(angle: Double) {
        TODO("Not yet implemented")
    }

    override fun rotateAroundZ(angle: Double) {
        TODO("Not yet implemented")
    }

    override fun destroy() {
        isDestroyed = true
        stop()
    }
}
