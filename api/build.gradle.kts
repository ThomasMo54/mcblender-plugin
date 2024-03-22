plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

dependencies {
    compileOnly(libs.spigot.api)
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

kotlin {
    jvmToolchain(11)
}
