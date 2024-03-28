package com.motompro.mcblender.core.config

import org.yaml.snakeyaml.LoaderOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor
import org.yaml.snakeyaml.introspector.BeanAccess
import org.yaml.snakeyaml.introspector.Property
import org.yaml.snakeyaml.introspector.PropertyUtils
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStream
import java.util.Locale

object PluginConfig {

    /**
     * Used to convert properties name that contain dashes to camel case
     */
    private val PROPERTY_UTILS = object : PropertyUtils() {
        override fun getProperty(type: Class<out Any>?, name: String?): Property {
            val formattedName = if (name?.contains('-') == true) {
                formatToCamelCase(name)
            } else {
                name
            }
            return super.getProperty(type, formattedName)
        }
    }

    private fun formatToCamelCase(str: String): String {
        val formattedString = str.split('-')
            .filter { it.isNotBlank() }
            .joinToString("") { "${it[0].uppercase(Locale.ENGLISH)}${it.substring(1)}" }
        return "${formattedString[0].lowercase(Locale.ENGLISH)}${formattedString.substring(1)}"
    }

    /**
     * Load config file data into a java bean. Note that properties names that contain dashes are reformatted to camel
     * case
     * @param file The config file
     * @param beanClass The class of the java bean
     * @throws FileNotFoundException
     */
    fun <T> loadFromFile(file: File, beanClass: Class<T>): T {
        if (!file.exists()) throw FileNotFoundException("${file.name} config file not found")
        val inputStream: InputStream = FileInputStream(file)
        val constructor = CustomClassLoaderConstructor(javaClass.classLoader)
        constructor.propertyUtils = PROPERTY_UTILS
        val yaml = Yaml(constructor)
        yaml.setBeanAccess(BeanAccess.FIELD)
        val config = yaml.loadAs(inputStream, beanClass)
        inputStream.close()
        return config
    }
}
