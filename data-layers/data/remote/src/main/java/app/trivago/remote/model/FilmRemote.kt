package app.trivago.remote.model

import com.google.gson.annotations.SerializedName

data class FilmRemote(
    @SerializedName("title")
    val title: String,
    @SerializedName("opening_crawl")
    val openingCrawl: String
)