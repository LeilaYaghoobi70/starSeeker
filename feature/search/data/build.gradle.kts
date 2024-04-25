plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "app.trivago.data"
    compileSdk = Config.Version.compileSdk

    defaultConfig {
        minSdk = Config.Version.minSdk

        testInstrumentationRunner = Config.Android.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(project(ProjectLib.network))
    implementation(project(ProjectLib.searchDomain))

    // hilt
    implementation(Dependencies.DI.hiltCore)
    kapt(Dependencies.DI.androidCompiler)

    // retrofit
    implementation(Dependencies.Network.gson)
    implementation(Dependencies.Network.retrofit)
}
