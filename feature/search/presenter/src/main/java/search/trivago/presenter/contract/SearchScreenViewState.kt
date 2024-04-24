package search.trivago.presenter.contract

import search.trivago.presenter.model.Character

data class SearchScreenViewState(
    val characters: List<Character>? = null,
    val showLoading: Boolean = false,
    val error: String? = null,
)
