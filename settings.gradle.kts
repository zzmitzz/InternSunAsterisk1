pluginManagement {
    repositories {
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jcenter.bintray.com")
    }
}

rootProject.name = "FirstAppandMaybeTheLast"
include(":app")
