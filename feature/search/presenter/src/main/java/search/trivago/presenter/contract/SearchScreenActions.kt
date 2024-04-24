package search.trivago.presenter.contract

import search.trivago.presenter.model.Character

data class SearchScreenActions(
    val search: (query: String) -> Unit = {},
    val navigateToDetail: (username: Character) -> Unit = {},
)
