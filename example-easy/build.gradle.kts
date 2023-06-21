plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm")

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

tasks.compileTestKotlin {
    kotlinOptions {
        javaParameters = true
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation("org.cojen:cojen-maker:2.4.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

application {
    // Define the main class for the application.
    mainClass.set("pt.isel.AppKt")
}
