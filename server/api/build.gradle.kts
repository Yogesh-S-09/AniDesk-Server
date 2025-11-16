plugins {
    kotlin("jvm") version "1.9.20"
    id("io.ktor.plugin") version "2.3.6"
    kotlin("plugin.serialization") version "1.9.20"
}

// ADD THIS BLOCK
// This explicitly tells this module where to look for dependencies
repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://github.com/Claudemirovsky/aniyomi-extensions-tester/raw/android-jar/")
}

group = "com.anidesk"
version = "0.0.1"

application {
    mainClass.set("com.anidesk.ServerKt")
}

dependencies {
    // Ktor Server Core
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")

    // This line depends on artifacts from JitPack
    implementation("aniyomi:anitester")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.4.11")
}