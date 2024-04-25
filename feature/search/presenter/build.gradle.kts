plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "app.trivago.presenter"
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

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.Version.kotlinCompilerExtensionVersion
    }
}

dependencies {

    implementation(project(ProjectLib.searchDomain))
    implementation(project(ProjectLib.design))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.lifecycle)
    implementation(Dependencies.AndroidX.viewModelLifecycle)

    // compose
    implementation(Dependencies.AndroidX.Compose.activityCompose)
    implementation(platform(Dependencies.AndroidX.Compose.composeBom))
    implementation(Dependencies.AndroidX.Compose.ui)
    implementation(Dependencies.AndroidX.Compose.uiGraphics)
    implementation(Dependencies.AndroidX.Compose.preview)
    implementation(Dependencies.AndroidX.Compose.material3)
    debugImplementation(Dependencies.AndroidX.Compose.uiTooling)
    debugImplementation(Dependencies.AndroidX.Compose.testManifest)

    // test
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.AndroidX.testExtJunit)
    androidTestImplementation(Dependencies.AndroidX.espresso)
    androidTestImplementation(Dependencies.AndroidX.Compose.composeBom)
    androidTestImplementation(Dependencies.AndroidX.Compose.junitUiTest)

    // hilt
    implementation(Dependencies.DI.hiltCore)
    implementation(Dependencies.DI.androidHilt)
    kapt(Dependencies.DI.androidCompiler)
    implementation(Dependencies.DI.navigationCompose)
}
