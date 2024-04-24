plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "app.trivago.presenter"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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

    implementation(project(ProjectLib.detailDomain))


    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.lifecycle)

    // compose
    implementation(Dependencies.AndroidX.Compose.activityCompose)
    implementation(platform(Dependencies.AndroidX.Compose.composeBom))
    implementation(Dependencies.AndroidX.Compose.ui)
    implementation(Dependencies.AndroidX.Compose.uiGraphics)
    implementation(Dependencies.AndroidX.Compose.preview)
    implementation(Dependencies.AndroidX.Compose.material3)
    debugImplementation(Dependencies.AndroidX.Compose.uiTooling)
    debugImplementation(Dependencies.AndroidX.Compose.testManifest)

    implementation(Dependencies.Network.gson)
    implementation(Dependencies.Network.retrofit)

    //test
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.AndroidX.testExtJunit)
    androidTestImplementation(Dependencies.AndroidX.espresso)
    androidTestImplementation(Dependencies.AndroidX.Compose.composeBom)
    androidTestImplementation(Dependencies.AndroidX.Compose.junitUiTest)

    // hilt
    implementation(Dependencies.DI.hiltCore)
    implementation(Dependencies.DI.androidHilt)
    kapt(Dependencies.DI.androidCompiler)
}