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
    private const val jUnitVersion = "4.13.2"

    const val junit = "junit:junit:${jUnitVersion}"

    object AndroidX {
        private object Version {
            const val coreVersion = "1.12.0"
            const val lifecycle = "2.7.0"
            const val activityCompose = "1.8.2"
            const val testExtJunit = "1.1.5"
            const val espresso = "3.5.1"
        }

        const val core = "androidx.core:core-ktx:${Version.coreVersion}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        const val testExtJunit = "androidx.test.ext:junit:${Version.testExtJunit}"

        const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"

        object Compose {
            const val activityCompose: String =
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

    object Network {
        private object Version {
            const val okhttp: String = "5.0.0-alpha.2"
            const val retrofit: String = "2.11.0"
            const val gsonConvertor: String = "2.0.2"
            const val gson: String = "2.10.1"

        }

        const val okhttp: String = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
        const val loggingInterceptor: String =
            "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
        const val retrofit: String = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitGson: String =
            "com.squareup.retrofit2:converter-gson:${Version.gsonConvertor}"
        const val gson: String = "com.google.code.gson:gson:${Version.gson}"
    }

    object DI {
        private object Version {
            const val hilt = "2.50"
            const val navigationCompose = "1.2.0"
            const val hiltCompiler = "1.0.0"
        }

        const val androidHilt = "com.google.dagger:hilt-android:${Version.hilt}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
        const val hiltCore: String = "com.google.dagger:hilt-core:${Version.hilt}"
        const val navigationCompose =
            "androidx.hilt:hilt-navigation-compose:${Version.navigationCompose}"
    }

    object Coroutines {
        private object Version {
            const val coroutines: String = "1.8.0"
        }

        const val core: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutines}"
        const val android: String =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

    }

    object NavHostVersion {
        object Version {
            const val nav_version: String = "2.7.7"
        }

        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Version.nav_version}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.nav_version}"
        const val navigationCompose =
            "androidx.navigation:navigation-compose:${Version.nav_version}"
    }
}

object ProjectLib {
    const val app = ":app"

    const val searchData = ":feature:search:data"
    const val searchDomain = ":feature:search:domain"
    const val searchPresenter = ":feature:search:presenter"

    const val detailData = ":feature:detail:data"
    const val detailDomain = ":feature:detail:domain"
    const val detailPresenter = ":feature:detail:presenter"

    const val network = ":network"
}