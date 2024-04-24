package app.trivago.domain.command

import app.trivago.domain.repository.SearchRepository
import app.trivago.domain.model.Character

sealed class SearchCommands<in T, out M> {

    data class GetCharacters(
        val character: String,
    ) : SearchCommands<SearchRepository, List<Character>?>() {
        override suspend fun execute(
            searchRepository: SearchRepository,
        ): List<Character>? =
            searchRepository.getCharacters(
                character = character
            )
    }

    internal abstract suspend fun execute(t: T): M?
}