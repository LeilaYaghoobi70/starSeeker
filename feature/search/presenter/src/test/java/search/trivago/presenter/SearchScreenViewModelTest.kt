package search.trivago.presenter

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import search.trivago.domain.model.Character
import search.trivago.domain.usecase.SearchUseCase
import search.trivago.presenter.model.mapper.toPresenter
import search.trivago.presenter.viewModel.SearchScreenViewModel

@OptIn(ExperimentalCoroutinesApi::class)
class SearchScreenViewModelTest {
    private val searchUseCase = mockk<SearchUseCase>(relaxed = true)
    private lateinit var viewModel: SearchScreenViewModel

    @get:Rule
    val mainDispatcherRule = MainCoroutineRule()

    @Before
    fun test() =
        runTest {
            viewModel =
                SearchScreenViewModel(searchUseCase = searchUseCase).also {
                    it.uiState.stateIn(CoroutineScope(mainDispatcherRule.testDispatcher))
                }
        }

    @Test
    fun return_characters_null_when_query_is_empty() =
        runTest {
            viewModel.search(query = "")
            assertEquals(null, viewModel.uiState.value.characters)
        }

    @Test
    fun return_characters_when_call_search_use_case() =
        runTest {
            val characters =
                arrayListOf(
                    Character(
                        name = "Leila",
                        birthYear = "1991",
                        height = "123",
                        films = listOf(""),
                        homeWorld = "",
                        species = listOf(""),
                        url = "",
                    ),
                )
            coEvery { searchUseCase.execute("Leila") } returns characters
            viewModel.search(query = "Leila")
            assertEquals(
                characters.map {
                    it.toPresenter()
                },
                viewModel.uiState.value.characters,
            )
        }

    @Test
    fun loading_is_false_when_throw_calling_search_use_case() =
        runTest {
            coEvery { searchUseCase.execute("Leila") } throws Throwable()
            viewModel.search(query = "Leila")
            assertEquals(
                false,
                viewModel.uiState.value.showLoading,
            )
        }
}
