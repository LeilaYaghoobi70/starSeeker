package app.trivago.remote.apiService

import app.trivago.remote.model.CharacterRemote
import app.trivago.remote.model.FilmRemote
import app.trivago.remote.model.PlanetRemote
import app.trivago.remote.model.SpecieRemote
import retrofit2.http.GET
import retrofit2.http.Url

interface StarApiService {

    @GET
    suspend fun fetchCharacterDetail(@Url url: String): CharacterRemote

    @GET(StarApiServiceEndPoint.FILM)
    suspend fun fetchSpecieDetails(@Url speciesUrl: String): SpecieRemote

    @GET(StarApiServiceEndPoint.FILM)
    suspend fun fetchFilmDetails(@Url filmsUrl: String): FilmRemote

    @GET(StarApiServiceEndPoint.PLANET)
    suspend fun fetchPlanet(@Url characterUrl: String): PlanetRemote
}
