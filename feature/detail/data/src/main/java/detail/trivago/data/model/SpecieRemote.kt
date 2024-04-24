package detail.trivago.data.model

import com.google.gson.annotations.SerializedName

data class SpecieRemote(
    @SerializedName("name")
    val name: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("homeWorld")
    val homeWorld: String?,
)
