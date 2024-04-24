package app.trivago.data.processor

import app.trivago.data.apiService.SearchApiService
import app.trivago.domain.model.Character
import app.trivago.domain.repository.SearchRepository

class SearchRepositoryImp(
    private val searchApiService: SearchApiService,
) : SearchRepository {
    override suspend fun getCharacters(character: String): List<Character>? {
        TODO("Not yet implemented")
    }

}
