pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://jitpack.io") // Add this
    }
}

dependencyResolutionManagement {
    // THIS IS THE NEW BLOCK YOU NEED TO ADD
    repositories {
        mavenCentral()
        maven("https://jitpack.io") // This will find the missing dependencies
    }

    // Your existing version catalogs
    versionCatalogs {
        create("libs") {
            from(files("server/extensions-tester/gradle/libs.versions.toml"))
        }
        create("androidcompat") {
            from(files("server/extensions-tester/gradle/androidcompat.versions.toml"))
        }
    }
}

rootProject.name = "AniDesk-Server"

include(":server:api")

// Your existing includeBuild
includeBuild("server/extensions-tester") {
    dependencySubstitution {
        substitute(module("aniyomi:anitester")).using(project(":anitester"))
    }
}