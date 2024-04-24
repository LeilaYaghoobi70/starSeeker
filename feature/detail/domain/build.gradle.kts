plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    // hilt
    implementation(Dependencies.DI.hiltCore)
    kapt(Dependencies.DI.androidCompiler)
}