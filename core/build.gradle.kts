plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version ("7.1.2")
}

group = rootProject.group
version = rootProject.version

dependencies {
    compileOnly(libs.spigot.api)
    implementation(project(":api"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}
