package app.trivago.domain.command

import app.trivago.domain.repository.SearchRepository
import javax.inject.Inject

class SearchCommandExecute @Inject constructor(
    private val searchRepository: SearchRepository,
) {
    suspend fun getCharactersDetails(
        character: String
    ) = SearchCommands.GetCharacters(
        character = character
    ).execute(searchRepository)
}
