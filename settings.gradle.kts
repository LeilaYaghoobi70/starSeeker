pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Star Seeker"
include(":app")
include(":navigation")

include(":network")
include(":feature:search:data")
include(":feature:search:domain")
include(":feature:search:presenter")
include(":feature:detail:data")
include(":feature:detail:domain")
include(":feature:detail:presenter")
