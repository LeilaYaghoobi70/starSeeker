plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // project
    implementation(project(ProjectLib.domain))

    // network
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.okhttp)
    implementation(Dependencies.Network.loggingInterceptor)
    implementation(Dependencies.Network.retrofitGson)
    implementation(Dependencies.Network.gson)

    // hilt
    implementation(Dependencies.DI.hiltCore)
    implementation(Dependencies.Network.retrofit)
}