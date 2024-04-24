package detail.trivago.data.apiService

import app.trivago.remote.model.FilmRemote
import detail.trivago.data.model.PlanetRemote
import detail.trivago.data.model.SpecieRemote
import retrofit2.http.GET
import retrofit2.http.Url

interface DetailApiService {
    @GET
    suspend fun fetchSpecieDetails(
        @Url speciesUrl: String,
    ): SpecieRemote

    @GET
    suspend fun fetchFilmDetails(
        @Url filmsUrl: String,
    ): FilmRemote

    @GET
    suspend fun fetchPlanet(
        @Url characterUrl: String,
    ): PlanetRemote
}
