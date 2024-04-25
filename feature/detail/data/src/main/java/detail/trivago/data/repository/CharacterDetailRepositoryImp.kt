package detail.trivago.data.repository

import detail.trivago.data.apiService.DetailApiService
import detail.trivago.data.model.mapper.toDomain
import detail.trivago.domain.model.Film
import detail.trivago.domain.model.Planet
import detail.trivago.domain.model.Species
import detail.trivago.domain.repository.CharacterDetailRepository

class CharacterDetailRepositoryImp(
    private val detailApiService: DetailApiService,
) : CharacterDetailRepository {
    override suspend fun fetchPlanet(planetUrl: String): Planet = detailApiService.fetchPlanet(planetUrl).toDomain()

    override suspend fun fetchSpecies(urls: List<String>): List<Species> {
        val specieDetails = fetchSpecieDetails(urls = urls)
        val specieMap: Map<String, String?> =
            urls.associateWith { url ->
                detailApiService.fetchPlanet(url).name
            }

        return specieDetails.map { specie ->
            val homeWorldName = specieMap[specie.homeWorld] ?: ""
            specie.copy(homeWorld = homeWorldName).toDomain()
        }
    }

    private suspend fun fetchSpecieDetails(urls: List<String>) =
        urls.map { url ->
            detailApiService.fetchSpecieDetails(url)
        }

    override suspend fun fetchFilms(urls: List<String>): List<Film> =
        urls.map { url ->
            detailApiService.fetchFilmDetails(url).toDomain()
        }
}
