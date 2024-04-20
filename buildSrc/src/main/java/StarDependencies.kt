const val kotlinAndroid: String = "android"

object Config {

    object Android {
        val namespace = "app.trivago.starseeker"
        val applicationId = "app.trivago.starseeker"
        val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Version {
        val compileSdk = 34
        val minSdk = 24
        val targetSdk = 34
        val versionCode = 1
        val versionName = "1.0"
        val kotlinCompilerExtensionVersion = "1.5.1"
    }
}

object Dependencies {

    private object Version {
        const val coreVersion = "1.12.0"
        const val lifecycle = "2.7.0"
        const val activityCompose = "1.8.2"
        const val jUnit = "4.13.2"
        const val testExtJunit = "1.1.5"
        const val espresso = "3.5.1"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:${Version.coreVersion}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        const val testExtJunit= "androidx.test.ext:junit:${Version.testExtJunit}"

        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"

        object Compose {
            const val activityCompose =
                "androidx.activity:activity-compose:${Version.activityCompose}"
            const val composeBom = "androidx.compose:compose-bom:2023.08.00"
            const val ui = "androidx.compose.ui:ui"
            const val uiGraphics = "androidx.compose.ui:ui-graphics"
            const val preview = "androidx.compose.ui:ui-tooling-preview"
            const val material3 = "androidx.compose.material3:material3"
            const val uiTooling = "androidx.compose.ui:ui-tooling"
            const val testManifest = "androidx.compose.ui:ui-test-manifest"
            const val junitUiTest = "androidx.compose.ui:ui-test-junit4"
        }
    }

    const val junit = "junit:junit:${Version.jUnit}"


}