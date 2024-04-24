package search.trivago.domain.usecase

import search.trivago.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUseCase
    @Inject
    constructor(
        private val searchRepository: SearchRepository,
    ) {
        suspend fun execute(query: String) =
            searchRepository.getCharacters(
                query = query,
            )
    }
