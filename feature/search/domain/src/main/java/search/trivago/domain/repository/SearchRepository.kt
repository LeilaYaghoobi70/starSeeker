package search.trivago.domain.repository

import search.trivago.domain.model.Character

interface SearchRepository {
    suspend fun getCharacters(query: String): List<Character>?
}
