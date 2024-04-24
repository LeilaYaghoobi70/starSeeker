package search.trivago.data.repository

import search.trivago.data.apiService.SearchApiService
import search.trivago.data.mapper.mapFromModel
import search.trivago.domain.model.Character
import search.trivago.domain.repository.SearchRepository

class SearchRepositoryImp(
    private val searchApiService: SearchApiService,
) : SearchRepository {
    override suspend fun getCharacters(query: String): List<Character>? {
        return searchApiService.fetchCharacter(
            query = query,
        )?.results?.map {
            it.mapFromModel()
        }
    }
}
