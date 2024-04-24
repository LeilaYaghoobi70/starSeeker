package app.trivago.domain.repository

import app.trivago.domain.model.Character

interface SearchRepository {
    suspend fun getCharacters(character: String): List<Character>?
}
