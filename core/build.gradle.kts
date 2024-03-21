plugins {
    kotlin("jvm")
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
    jvmToolchain(17)
}
