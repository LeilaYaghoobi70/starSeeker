plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Config.Android.namespace
    compileSdk = Config.Version.compileSdk

    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdk = Config.Version.minSdk
        targetSdk = Config.Version.targetSdk
        versionCode = Config.Version.versionCode
        versionName = Config.Version.versionName
        testInstrumentationRunner = Config.Android.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.Version.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(ProjectLib.domain))
    implementation(project(ProjectLib.remote))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.lifecycle)

    implementation(Dependencies.AndroidX.Compose.activityCompose)
    implementation(platform(Dependencies.AndroidX.Compose.composeBom))
    implementation(Dependencies.AndroidX.Compose.ui)
    implementation(Dependencies.AndroidX.Compose.uiGraphics)
    implementation(Dependencies.AndroidX.Compose.preview)
    implementation(Dependencies.AndroidX.Compose.material3)

    debugImplementation(Dependencies.AndroidX.Compose.uiTooling)
    debugImplementation(Dependencies.AndroidX.Compose.testManifest)

    //test
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.AndroidX.testExtJunit)
    androidTestImplementation(Dependencies.AndroidX.espresso)
    androidTestImplementation(platform(Dependencies.AndroidX.Compose.composeBom))
    androidTestImplementation(Dependencies.AndroidX.Compose.junitUiTest)

}