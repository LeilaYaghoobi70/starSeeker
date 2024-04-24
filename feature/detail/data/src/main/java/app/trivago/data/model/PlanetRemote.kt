package app.trivago.data.model

import com.google.gson.annotations.SerializedName

data class PlanetRemote(
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: String,
)
