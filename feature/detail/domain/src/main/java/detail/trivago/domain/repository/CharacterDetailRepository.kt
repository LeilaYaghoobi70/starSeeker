package detail.trivago.domain.repository

import detail.trivago.domain.model.Film
import detail.trivago.domain.model.Planet
import detail.trivago.domain.model.Specie

interface CharacterDetailRepository {
    suspend fun fetchPlanet(planetUrl: String): Planet

    suspend fun fetchSpecies(urls: List<String>): List<Specie>

    suspend fun fetchFilms(urls: List<String>): List<Film>
}
