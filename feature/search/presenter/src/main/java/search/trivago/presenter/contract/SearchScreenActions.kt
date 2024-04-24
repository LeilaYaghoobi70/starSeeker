package search.trivago.presenter.contract

import search.trivago.domain.model.Character

data class SearchScreenActions(
    val search: (query: String) -> Unit = {},
    val navigateToDetail: (username: Character) -> Unit = {},
)
