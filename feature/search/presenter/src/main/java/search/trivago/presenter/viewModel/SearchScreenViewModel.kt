package search.trivago.presenter.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import search.trivago.domain.usecase.SearchUseCase
import search.trivago.presenter.contract.SearchScreenViewState
import search.trivago.presenter.model.toPresenterCharacter
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel
    @Inject
    constructor(
        private val searchUseCase: SearchUseCase,
    ) : ViewModel() {
        private val viewModelState = MutableStateFlow(SearchScreenViewState())
        val uiState =
            viewModelState.stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = viewModelState.value,
            )

        private var searchDebounceJob: Job? = null
        private var previewQuery = ""

        fun search(query: String) {
            if (isNotNewQuery(query)) {
                return
            }
            previewQuery = query
            if (query.isEmpty()) {
                viewModelState.update { state ->
                    state.copy(characters = null)
                }
                searchDebounceJob?.cancel()
                return
            }
            searchCharacters(query = query)
        }

        private fun isNotNewQuery(query: String): Boolean = query == previewQuery

        private fun searchCharacters(query: String) {
            val coroutineExceptionHandler =
                CoroutineExceptionHandler { _, _ ->
                    viewModelState.update { searchStateScreen ->
                        searchStateScreen.copy(showLoading = false)
                    }
                }
            searchDebounceJob?.cancel()
            searchDebounceJob =
                viewModelScope.launch(
                    coroutineExceptionHandler,
                ) {
                    viewModelState.update { searchStateScreen ->
                        searchStateScreen.copy(showLoading = true)
                    }
                    val characters =
                        searchUseCase.execute(query = query)?.map {
                            it.toPresenterCharacter()
                        }
                    viewModelState.update { searchStateScreen ->
                        searchStateScreen.copy(
                            characters = characters,
                            showLoading = false,
                        )
                    }
                }
        }
    }
