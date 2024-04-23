package app.trivago.remote.model

import com.google.gson.annotations.SerializedName

data class PlanetRemote(
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: String,
)