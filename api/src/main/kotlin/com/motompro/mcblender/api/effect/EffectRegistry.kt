package com.motompro.mcblender.api.effect

import java.io.File

/**
 * An interface that describes the management of multiple [Effect].
 */
interface EffectRegistry {

    /**
     * Get an [Effect] giving the name of the file containing its data (assuming the file is inside the plugin's config
     * directory).
     *
     * @param fileName the file's name
     * @return the [Effect] if found and if the file is correctly formatted
     */
    fun loadEffect(fileName: String): Effect

    /**
     * Get an [Effect] giving the file containing its data.
     *
     * @param file the file
     * @return the [Effect] if the file is correctly formatted
     */
    fun loadEffect(file: File): Effect
}
