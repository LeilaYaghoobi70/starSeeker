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

    // network
    api(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.okhttp)
    implementation(Dependencies.Network.loggingInterceptor)
    implementation(Dependencies.Network.retrofitGson)
    implementation(Dependencies.Network.gson)

    // hilt
    implementation(Dependencies.DI.hiltCore)
    kapt(Dependencies.DI.androidCompiler)
}