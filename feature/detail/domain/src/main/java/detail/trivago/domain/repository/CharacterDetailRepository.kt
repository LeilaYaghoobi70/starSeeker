package detail.trivago.domain.repository

import detail.trivago.domain.model.Film
import detail.trivago.domain.model.Planet
import detail.trivago.domain.model.Species

interface CharacterDetailRepository {
    suspend fun fetchPlanet(planetUrl: String): Planet

    suspend fun fetchSpecies(urls: List<String>): List<Species>

    suspend fun fetchFilms(urls: List<String>): List<Film>
}
