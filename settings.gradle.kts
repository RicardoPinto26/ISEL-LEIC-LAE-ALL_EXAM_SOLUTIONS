pluginManagement {
    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.8.10"
    }
}

rootProject.name = "all_tests"

include("v2122-t1")
include("v2122-t2")

include("example-easy")
include("example-hard")